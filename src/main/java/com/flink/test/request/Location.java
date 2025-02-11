package com.flink.test.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Location {

    @NotNull(message = "lat is mandatory")
    private Double lat;
    @NotNull(message = "long is mandatory")
    @JsonProperty("long")
    private Double log;
}
