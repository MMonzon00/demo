package lp3.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;



public class Product{

    private final UUID id;
    private final String name;

    private final float weight;

    private final String type;

    public Product(@JsonProperty("id") UUID id,
                        @JsonProperty("name") String name,
                        @JsonProperty("weight") float weight,
                        @JsonProperty("type") String type
    ) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
