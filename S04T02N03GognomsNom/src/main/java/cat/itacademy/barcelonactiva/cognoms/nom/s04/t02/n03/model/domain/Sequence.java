package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.model.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;


@Document("sequence")
public class Sequence {
    @Id
    private String id;
    private int seq;

    public Sequence() {
    }

    public Sequence(String id, int seq) {
        this.id = id;
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
