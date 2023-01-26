package lp3.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;



public class Product extends Invoice{

    private final UUID id;
    private final String name;

    private final float weight;

    private final String type;


    public Product(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name,
                   @JsonProperty("weight") float weight,
                   @JsonProperty("type") String type,
                   @JsonProperty("price")Long price

    ) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.setPrice(price);
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
