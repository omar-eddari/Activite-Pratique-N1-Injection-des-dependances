package app;
import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;
/**
 * @author user
 **/
public class PresentationInjectionSpringXml {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-ioc.xml");
        IMetier metier = context.getBean("metier", IMetier.class);
        System.out.println(metier.calcul());
    }
}
