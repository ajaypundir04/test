package com.flink.test.service;

import com.flink.test.exception.LocationNotFoundException;
import com.flink.test.repository.LocationRepo;
import com.flink.test.request.Location;
import com.flink.test.response.RiderLocation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepo locationRepo;

    public void saveLocation(String riderId, Location location) {
        locationRepo.addLocation(riderId, location);
        log.info("Saving location {} for {}", location, riderId);
    }

    public RiderLocation readNLatestLocation(String riderId, String max) {
        List<Location> locations = locationRepo.getLocationByRider(riderId)
                .orElseThrow(() -> new LocationNotFoundException("Rider not found"));
        RiderLocation riderLocation = new RiderLocation();
        riderLocation.setRiderId(riderId);
        riderLocation.setHistory(getNLatestLocation(locations, max));
        log.info("Rider Locations {}", riderLocation);
        return riderLocation;
    }

    private List<Location> getNLatestLocation(List<Location> locations, String max) {
        int top = Integer.parseInt(max);
        log.info("Fetching {} location", top);
        List<Location> result = new ArrayList<>();
        int idx = locations.size() - 1;
        if (top > idx) {
            return locations;
        }
        while (top > 0) {
            result.add(locations.get(idx));
            idx--;
            top--;
        }
        return result;
    }
}
