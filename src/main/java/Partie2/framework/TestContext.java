package Partie2.framework;

import Partie2.framework.context.ApplicationContextConstructorInjection;
import Partie2.framework.xml.BeanDefinitionParser;
import Partie2.framework.xml.Beans;
import Partie2.framework.xml.XmlBeanDefinitionReader;
import Partie1.metier.MetierImpl;

/**
 * @author user
 **/
public class TestContext {
    public static void main(String[] args) {

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader();
        Beans beansXml = reader.loadBeans("config.xml");

        BeanDefinitionParser parser = new BeanDefinitionParser();
        var definitions = parser.parse(beansXml);

        ApplicationContextConstructorInjection context = new ApplicationContextConstructorInjection(definitions);

        MetierImpl service = (MetierImpl)  context.getBean("Partie1/metier");
        System.out.println(service.calcul());
    }
}
