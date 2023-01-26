package lp3.backend.service;

import lp3.backend.dao.OrganizationDao;
import lp3.backend.domain.Organization;
import lp3.backend.utilities.EmailValidation;
import lp3.backend.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationService {

    //Instance of where we will store all data
    private final OrganizationDao OrganizationDao;

    private final EmailValidation emailValidation;
    @Autowired
    public OrganizationService(@Qualifier("organizationDao") OrganizationDao OrganizationDao,EmailValidation emailValidation) {
        this.OrganizationDao = OrganizationDao;
        this.emailValidation = emailValidation;
    }

    public void addOrganization(Organization organization){
        if (!emailValidation.test(organization.getEmail())) {
            throw new ApiRequestException(organization.getEmail() + " is not valid");
        }
        OrganizationDao.insertOrganization(organization);
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

    public void deleteOrganization(UUID id){
        OrganizationDao.deleteOrganizationById(id);
    }

    public void updateOrganization(UUID id, Organization newOrganization) {
        if (!emailValidation.test(newOrganization.getEmail())) {
            throw new ApiRequestException(newOrganization.getEmail() + " is not valid");
        }
        OrganizationDao.updateOrganizationById(id, newOrganization);
    }
}
