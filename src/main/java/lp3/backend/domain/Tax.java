package lp3.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;



public class Tax {


    private final UUID id;

    private final String type;

    private final float percentage;


    public Tax(@JsonProperty("id") UUID id,
               @JsonProperty("type") String type,
               @JsonProperty("percentage")float percentage
    ) {
        this.id = id;
        this.type = type;
        this.percentage = percentage;
    }

    public UUID getId() {
        return id;
    }

    public float getPercentage() {
        return percentage;
    }

    public String getType() {
        return type;
    }
}