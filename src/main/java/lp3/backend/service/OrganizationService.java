package lp3.backend.service;

import lp3.backend.dao.OrganizationDao;
import lp3.backend.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationService {

    private final OrganizationDao OrganizationDao;
    @Autowired
    public OrganizationService(@Qualifier("organizationDao") OrganizationDao OrganizationDao) {
        this.OrganizationDao = OrganizationDao;
    }

    public int addOrganization(Organization organization){
        return OrganizationDao.insertOrganization(organization);
    }

    public List<Organization> getAllOrganizations(){
        return OrganizationDao.selectAllOrganizations();
    }

    public Optional<Organization> getOrganizationById(UUID id){
        return OrganizationDao.selectOrganizationById(id);
    }

//    public Optional<Organization> getOrganizationByType(String type){
//        return OrganizationDao.selectOrganizationByType(type);
//    }

    public int deleteOrganization(UUID id){
        return OrganizationDao.deleteOrganizationById(id);
    }

    public int updateOrganization(UUID id, Organization newOrganization) {
        return OrganizationDao.updateOrganizationById(id, newOrganization);
    }
}
