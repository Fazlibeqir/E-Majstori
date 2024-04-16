package ukim.finki.backend.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.backend.model.Location;
import ukim.finki.backend.service.LocationService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/location")
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.findAll();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Location location = locationService.findById(id);
        if (location != null) {
            return ResponseEntity.ok().body(location);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-location")
    public ResponseEntity<Location> addLocation(@RequestParam String city,
                                                @RequestParam String country) {
        if(city == null || country == null){
            return ResponseEntity.badRequest().build();
        }
        Location location = locationService.create(city, country);
        return ResponseEntity.ok().body(location);
    }

    @DeleteMapping("/delete-location/{id}")
    public ResponseEntity deleteLocation(@PathVariable Long id) {
        if(id == null || locationService.findById(id) == null){
            return ResponseEntity.badRequest().build();
        }
        locationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}