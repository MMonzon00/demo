package lp3.backend.repository;

import lp3.backend.dao.OrganizationDao;
import lp3.backend.model.Organization;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("organizationDao")
public class OrganizationRepo implements OrganizationDao {

    private static List<Organization> DB = new ArrayList<>();

    @Override
    public int insertOrganization(UUID id, Organization Organization){
        DB.add(new Organization(id, Organization.getName(),Organization.getEmail(), Organization.getType()));
        return 0;
    }

    @Override
    public List<Organization> selectAllOrganizations() {
        return DB;
    }

    @Override
    public Optional<Organization> selectOrganizationById(UUID id) {
        return DB.stream()
                .filter(Organization -> Organization.getId().equals(id))
                .findFirst();
    }

//    @Override
//    public Optional<Organization> selectOrganizationByType(String Type) {
//        return System.out.println(DB.stream());
//
//    }

    @Override
    public int deleteOrganizationById(UUID id) {
        Optional<Organization> OrganizationMaybe = selectOrganizationById(id);
        if (OrganizationMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(OrganizationMaybe.get());
        return 1;
    }


    @Override
    public int updateOrganizationById(UUID id, Organization update) {
        return selectOrganizationById(id)
                .map(Organization -> {
                    int indexOfOrganizationToUpdate = DB.indexOf(Organization);
                    if (indexOfOrganizationToUpdate >= 0){
                        DB.set(indexOfOrganizationToUpdate, new Organization(id, update.getName(), update.getEmail(), update.getType()));
                        return 1;
                    }
                    return 0;
                } )
                .orElse(0);
    }

}
