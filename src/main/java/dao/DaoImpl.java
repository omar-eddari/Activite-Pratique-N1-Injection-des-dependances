package dao;

import org.springframework.stereotype.Component;

/**
 * @author user
 **/
@Component("d")
public class DaoImpl implements IDao{
    public double getValue() {
        return 5;
    }
}
