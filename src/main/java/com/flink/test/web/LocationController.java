package com.flink.test.web;

import com.flink.test.request.Location;
import com.flink.test.response.RiderLocation;
import com.flink.test.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("location/{rider_id}")
@RequiredArgsConstructor
@Validated
public class LocationController {

    private final LocationService locationService;
    @PostMapping("/now")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLocation(@PathVariable("rider_id") String riderId,
                             @RequestBody @Valid Location location){
        locationService.saveLocation( riderId, location);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RiderLocation readNLatestLocation(@PathVariable("rider_id") String riderId,
                                             @RequestParam(required = false) String max){
        return locationService.readNLatestLocation( riderId, max);
    }

}
