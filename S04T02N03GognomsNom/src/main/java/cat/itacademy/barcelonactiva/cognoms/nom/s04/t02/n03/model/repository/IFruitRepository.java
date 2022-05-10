package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFruitRepository extends MongoRepository<Fruit, Integer> {

}
