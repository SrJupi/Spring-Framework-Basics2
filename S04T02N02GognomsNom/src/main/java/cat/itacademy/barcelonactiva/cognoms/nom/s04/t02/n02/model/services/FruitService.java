package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.repository.IFruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private IFruitRepository repository;

    public ResponseEntity<?> getFruits(){
        List<Fruit> fruitList = repository.findAll();
        if (!fruitList.isEmpty()){
            return new ResponseEntity<>(fruitList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("404 - Database is empty!", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getFruit(Integer id) {
        Optional<Fruit> optionalFruit = repository.findById(id);
        if (optionalFruit.isPresent()){
            return new ResponseEntity<>(optionalFruit.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(String.format("404 - ID %d not found!", id), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> addFruit(Fruit fruit) {
        if ((fruit.getName() != null) && (fruit.getWeight() > 0) && !repository.existsById(fruit.getId())){
            repository.save(fruit);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setLocation(URI.create(String.format("/fruita/%d", fruit.getId())));
            return new ResponseEntity<>(String.format("201 - resource created successfully on /fruita/%d", fruit.getId()),
                    responseHeaders, HttpStatus.CREATED);
        }else{
            if (fruit.getName() == null){
                return new ResponseEntity<>("400 - Name is empty!", HttpStatus.BAD_REQUEST);
            }else if (fruit.getWeight() <= 0){
                return new ResponseEntity<>("400 - Weight have to be bigger than zero!", HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>("400 - ID already exists on database!", HttpStatus.BAD_REQUEST);
            }
        }

    }

    public ResponseEntity<?> updateFruit(Fruit fruit) {
        if ((fruit.getName() != null) && (fruit.getWeight() > 0) && repository.existsById(fruit.getId())){
            repository.save(fruit);
            return new ResponseEntity<>(String.format("200 - resource updated successfully on /fruita/%d", fruit.getId()),HttpStatus.OK);
        } else {
            if (fruit.getName() == null){
                return new ResponseEntity<>("400 - Name is empty!", HttpStatus.BAD_REQUEST);
            }else if (fruit.getWeight() <= 0){
                return new ResponseEntity<>("400 - Weight have to be bigger than zero!", HttpStatus.BAD_REQUEST);
            }else{
                return addFruit(fruit);
            }
        }
    }

    public ResponseEntity<?> deleteFruit(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return new ResponseEntity<>(String.format("200 - ID %d deleted", id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(String.format("404 - ID %d not found!", id), HttpStatus.NOT_FOUND);
        }
    }
}
