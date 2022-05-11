package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.model.domain;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.model.repository.ISeqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SequenceService {

    @Autowired
    private ISeqRepository repository;

    public int generateSequence(String seqName) {
        Optional<Sequence> optionalSequence = repository.findById(seqName);
        Sequence sequence = null;
        if (optionalSequence.isPresent()){
            sequence = optionalSequence.get();
            sequence.setSeq(sequence.getSeq() + 1);
            repository.save(sequence);
        }else{
            sequence = new Sequence();
            sequence.setId(seqName);
            sequence.setSeq(0);
            repository.save(sequence);
        }
        return sequence.getSeq();
    }

}
