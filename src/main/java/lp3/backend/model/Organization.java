package lp3.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Organization {
        private final UUID id;
        private final String name;

        private final String email;

        public Organization(@JsonProperty("id") UUID id,
                    @JsonProperty("name") String name,
                    @JsonProperty("email") String email
        ) {
            this.id = id;
            this.name = name;
            this.email = email;
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
}
