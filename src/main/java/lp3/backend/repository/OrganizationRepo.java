package lp3.backend.repository;

import lp3.backend.dao.OrganizationDao;
import lp3.backend.domain.Organization;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("organizationDao")
public class OrganizationRepo implements OrganizationDao {

    private final static List<Organization> orgDB = new ArrayList<>();

    @Override
    public int insertOrganization(UUID id, Organization Organization){
        orgDB.add(new Organization(id, Organization.getName(),Organization.getEmail(), Organization.getType(),Organization.getAddress(),Organization.getOrganizationID()));
        return 0;
    }

    @Override
    public List<Organization> selectAllOrganizations() {
        return orgDB;
    }

    @Override
    public Optional<Organization> selectOrganizationById(UUID id) {
        return orgDB.stream()
                .filter(Organization -> Organization.getId().equals(id))
                .findFirst();
    }



/*
    @Override
    public ArrayList<Organization> selectbyType(String type) {
        return finorgDByTipo(type);
    }
*/

    @Override
    public void deleteOrganizationById(UUID id) {
        Optional<Organization> OrganizationMaybe = selectOrganizationById(id);
        if (OrganizationMaybe.isEmpty()) {
            return;
        }
        orgDB.remove(OrganizationMaybe.get());
    }


    @Override
    public void updateOrganizationById(UUID id, Organization update) {
        selectOrganizationById(id)
                .map(Organization -> {
                    int indexOfOrganizationToUpdate = orgDB.indexOf(Organization);
                    if (indexOfOrganizationToUpdate >= 0) {
                        orgDB.set(indexOfOrganizationToUpdate, new Organization(id, update.getName(), update.getEmail(), update.getType(),update.getAddress(), update.getOrganizationID()));
                        return 1;
                    }
                    return 0;
                });
    }

}
