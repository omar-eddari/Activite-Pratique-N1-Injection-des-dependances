package Partie1.dao;

import org.springframework.stereotype.Component;

//import framework.annotation.Component;

/**
 * @author user
 **/
@Component
public class DaoImpl implements IDao{
    public double getValue() {
        return 5;
    }
}
