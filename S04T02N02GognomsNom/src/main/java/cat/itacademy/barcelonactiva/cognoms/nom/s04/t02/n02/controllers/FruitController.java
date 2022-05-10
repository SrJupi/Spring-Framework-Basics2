package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {

    @Autowired
    private FruitService service;

    @GetMapping("/fruita/getAll")
    public ResponseEntity<?> getFruits(){
        return service.getFruits();
    }

    @GetMapping("/fruita/getOne/{id}")
    public ResponseEntity<?> getFruit(@PathVariable Integer id){
        return service.getFruit(id);
    }

    @PostMapping("/fruita/add")
    public ResponseEntity<?> addFruit(@RequestBody Fruit fruit){
        return service.addFruit(fruit);
    }

    @PutMapping("fruita/update")
    public ResponseEntity<?> updateFruit(@RequestBody Fruit fruit){
        return service.updateFruit(fruit);
    }

    @DeleteMapping("fruita/delete/{id}")
    public ResponseEntity<?> deleteFruit(@PathVariable Integer id){
        return service.deleteFruit(id);
    }

}
