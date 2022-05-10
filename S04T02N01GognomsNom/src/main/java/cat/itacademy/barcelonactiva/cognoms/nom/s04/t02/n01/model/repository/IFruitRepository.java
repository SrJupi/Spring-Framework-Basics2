package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFruitRepository extends JpaRepository<Fruit, Integer> {

}
