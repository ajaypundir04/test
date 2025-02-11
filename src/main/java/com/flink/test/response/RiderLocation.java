package com.flink.test.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flink.test.request.Location;
import lombok.Data;

import java.util.List;

@Data
public class RiderLocation {
    @JsonProperty("rider_id")
    private String riderId;
    private List<Location> history;
}
