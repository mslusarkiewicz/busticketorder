package com.sii.busticketorder.controller;

import com.sii.busticketorder.model.Route;
import com.sii.busticketorder.model.RouteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class RouteController {
    private final RouteRepository routeRepository;

    RouteController(final RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @GetMapping("/routes/buyticket/{number}")
    ResponseEntity<?> butTicket(@PathVariable int number){
        return ResponseEntity.ok("Kupiono bilet, zaplac: " + routeRepository.findAllByNumber(number).stream().findFirst().get().getPrice());
    }

    @PostMapping("/routes")
    ResponseEntity<Route> createRoute(@RequestBody Route toCreate){
        Route result = routeRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/routes")
    ResponseEntity<List<Route>> readAllRoutes(){
        return ResponseEntity.ok(routeRepository.findAll());
    }

    @PutMapping("/routes/{id}")
    ResponseEntity<?> updateRoute(@PathVariable int id, @RequestBody Route toUpdate){
        if(!routeRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        routeRepository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
}
