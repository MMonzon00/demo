package lp3.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;


public class Organization{
        private final UUID id;
        private final String name;

        private final String email;

        private final String type;

        private final String address;

        private final Long organizationID;

        public Organization(@JsonProperty("id") UUID id,
                            @JsonProperty("name") String name,
                            @JsonProperty("email") String email,
                            @JsonProperty("type") String type,
                            @JsonProperty("address") String address,
                            @JsonProperty("organizationId") Long organizationID) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.type = type;
            this.address = address;
            this.organizationID = organizationID;
        }

    public UUID getId() {
            return id;
        }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public Long getOrganizationID() {
        return organizationID;
    }

    public String getAddress() {
        return address;
    }
}

