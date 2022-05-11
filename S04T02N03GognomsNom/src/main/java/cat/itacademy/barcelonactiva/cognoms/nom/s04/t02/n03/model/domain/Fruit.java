package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.model.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;

@Document("fruits")
public class Fruit {

    @Transient
    public static final String SEQ_NAME = "fruit_id";

    @Id
    private int id;
    private String name;
    private int weight;

    public Fruit() {
    }

    public Fruit(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
