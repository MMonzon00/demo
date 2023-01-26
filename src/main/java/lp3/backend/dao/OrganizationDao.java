package lp3.backend.dao;

import lp3.backend.domain.Organization;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationDao {
    int insertOrganization (UUID id, Organization organization);

    default void insertOrganization(Organization organization){
        UUID id = UUID.randomUUID();
        insertOrganization(id, organization);
    }

    List<Organization> selectAllOrganizations();

    Optional<Organization> selectOrganizationById(UUID id);

//    Optional<Organization> selectOrganizationByType(String type);

    void deleteOrganizationById(UUID id);

    void updateOrganizationById(UUID id, Organization organization);


}

