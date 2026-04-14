package Partie1.app;

import Partie1.dao.DaoImpl;
import Partie1.metier.MetierImpl;

/**
 * @author user
 **/
public class PresentationStatic {
    public static void main(String[] args) {
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl(dao);
        metier.setDao(dao);
        System.out.println(metier.calcul());
    }
}
