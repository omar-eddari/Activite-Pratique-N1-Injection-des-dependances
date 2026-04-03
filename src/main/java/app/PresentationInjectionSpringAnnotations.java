package app;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author user
 **/
public class PresentationInjectionSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext("dao","metier");
        IMetier metier = ctx.getBean( IMetier.class);
        System.out.println(metier.calcul());
    }
}
