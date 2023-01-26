package lp3.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;


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