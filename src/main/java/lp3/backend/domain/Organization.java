package lp3.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;


public class Organization{
        private final UUID id;
        private final String name;

        private final String email;

        private final String type;

        public Organization(@JsonProperty("id") UUID id,
                            @JsonProperty("name") String name,
                            @JsonProperty("email") String email,
                            @JsonProperty("type") String type) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.type = type;
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
}
