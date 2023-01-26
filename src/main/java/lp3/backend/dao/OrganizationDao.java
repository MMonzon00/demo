package lp3.backend.dao;

import lp3.backend.model.Organization;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationDao {
    int insertOrganization (UUID id, Organization organization);

    default int insertOrganization(Organization organization){
        UUID id = UUID.randomUUID();
        return insertOrganization(id, organization);
    }

    List<Organization> selectAllOrganizations();

    Optional<Organization> selectOrganizationById(UUID id);

//    Optional<Organization> selectOrganizationByType(String type);

    int deleteOrganizationById(UUID id);

    int updateOrganizationById(UUID id, Organization organization);
}

