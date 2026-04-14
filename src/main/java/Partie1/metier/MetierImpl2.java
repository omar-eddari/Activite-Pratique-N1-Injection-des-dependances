package Partie1.metier;

import Partie1.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author user
 **/
@Component
@Primary
public class MetierImpl2 implements IMetier{
    @Autowired
    private IDao dao;
    public double calcul() {
        double nb=dao.getValue();
        return 3*nb;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

}
