package app;

import dao.DaoImpl;
import metier.MetierImpl;

/**
 * @author user
 **/
public class PresentationStatic {
    public static void main(String[] args) {
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcul());
    }
}
