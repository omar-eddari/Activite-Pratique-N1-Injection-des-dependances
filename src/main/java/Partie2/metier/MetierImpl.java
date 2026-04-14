package Partie2.metier;

import Partie2.framework.annotation.Component;
import Partie2.dao.IDao;
import Partie2.framework.annotation.Inject;

/**
 * @author user
 **/
@Component
public class MetierImpl implements IMetier {
    @Inject
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
