package com.flink.test.repository;

import com.flink.test.request.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class LocationRepoTest {

    private final LocationRepo locationRepo = new LocationRepo();

    @Test
    public void testAddLocation() {
        // Given
        Location location = new Location();
        location.setLat(1.0);
        location.setLat(2.0);

        // When
        locationRepo.addLocation("some-one", location);

        // then
        Optional<List<Location>> response = locationRepo.getLocationByRider("some-one");
        Assertions.assertTrue(response.isPresent());
        Assertions.assertEquals(location, response.get().get(0));
    }

}
