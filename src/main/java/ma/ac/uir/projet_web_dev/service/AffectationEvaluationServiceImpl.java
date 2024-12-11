package ma.ac.uir.projet_web_dev.service;


import ma.ac.uir.projet_web_dev.dao.AffectationEvaluationRepository;
import ma.ac.uir.projet_web_dev.entity.AffectationEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffectationEvaluationServiceImpl implements AffectationEvaluationService{
    private AffectationEvaluationRepository affectationEvaluationRepository;

    @Autowired
    public AffectationEvaluationServiceImpl(AffectationEvaluationRepository theAERepository){
        this.affectationEvaluationRepository = theAERepository;
    }
    @Override
    public AffectationEvaluation save(AffectationEvaluation theaffectation) {
        return affectationEvaluationRepository.save(theaffectation);
    }
}
