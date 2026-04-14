package Partie1.metier;

import Partie1.dao.IDao;
//import framework.annotation.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author user
 **/
@Component
public class MetierImpl implements IMetier{
    @Autowired
    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl() {
    }

    public double calcul() {
        double nb=dao.getValue();
        return 2*nb;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

}
