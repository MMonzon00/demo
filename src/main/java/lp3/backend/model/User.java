package lp3.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String username;

    private final String email;

    private final String organization;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("username") String username,
                @JsonProperty("email") String email,
                @JsonProperty("organization") String organization
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.organization = organization;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }
}
