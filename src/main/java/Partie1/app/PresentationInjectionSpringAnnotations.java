package Partie1.app;

import Partie1.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author user
 **/
public class PresentationInjectionSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext("Partie1/dao", "Partie1/metier");
        IMetier metier = ctx.getBean( IMetier.class);
        System.out.println(metier.calcul());
    }
}
