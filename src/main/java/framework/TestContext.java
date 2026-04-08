package framework;

import framework.context.ApplicationContext;
import framework.context.ApplicationContextConstructorInjection;
import framework.context.ApplicationContextSetterInjection;
import framework.xml.BeanDefinitionParser;
import framework.xml.Beans;
import framework.xml.XmlBeanDefinitionReader;
import metier.MetierImpl;

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

        MetierImpl service = (MetierImpl)  context.getBean("metier");
        System.out.println(service.calcul());
    }
}
