package com.flink.test.repository;

import com.flink.test.request.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LocationRepo {

    private final Map<String, List<Location>> locationStore = new ConcurrentHashMap<>();

    public void addLocation(String riderId, Location location) {
        if (locationStore.containsKey(riderId)) {
            locationStore.get(riderId).add(location);
        } else {
            List<Location> list = new ArrayList<>();
            list.add(location);
            locationStore.put(riderId, list);
        }
    }

    public Optional<List<Location>> getLocationByRider(String riderId) {
       return Optional.ofNullable(locationStore.get(riderId));
    }

}
