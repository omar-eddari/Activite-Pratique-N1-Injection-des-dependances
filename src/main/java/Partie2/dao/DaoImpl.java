package Partie2.dao;

//import org.springframework.stereotype.Component;

import Partie2.framework.annotation.Component;

/**
 * @author user
 **/
@Component
public class DaoImpl implements IDao {
    public double getValue() {
        return 5;
    }
}
