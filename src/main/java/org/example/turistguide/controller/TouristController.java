package org.example.turistguide.controller;

import org.example.turistguide.model.TouristAttraction;
import org.example.turistguide.service.TouristService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) { // constructor injection
        this.touristService = touristService;
    }

    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAll() {
        return ResponseEntity.ok(touristService.getAllTouristAttractions());
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getByName(@PathVariable String name) { // GET /attractions/{name}
        TouristAttraction attraction = touristService.getTouristAttractionByName(name);
        if (attraction == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(attraction);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> add(@RequestBody TouristAttraction touristAttraction) { // POST /attractions/add
        return ResponseEntity.ok(touristService.addTouristAttraction(touristAttraction));
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> update(@RequestBody TouristAttraction touristAttraction) { // POST /attractions/update
        TouristAttraction updated = touristService.updateTouristAttraction(touristAttraction.getName(), touristAttraction);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<String> delete(@PathVariable String name) { // POST /attractions/delete/{name}
        boolean deleted = touristService.deleteTouristAttraction(name);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Attraktion slettet");
    }
}