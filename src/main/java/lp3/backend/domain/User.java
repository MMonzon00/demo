package lp3.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.UUID;


public class User{

    //Primary key
    private final UUID id;


    @Column
    @NonNull
    private final String username;

    @Column
    @NonNull
    private final String email;

    @Column
    @NonNull
    public final String type;

    @Column
    @NonNull
    private final String organization;


    public User(@JsonProperty("id") UUID id,
                @JsonProperty("username") String username,
                @JsonProperty("email") String email,
                @JsonProperty("type") String type,
                @JsonProperty("organization") String organization
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.type = type;
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


    public String getType() {
        return type;
    }
}
