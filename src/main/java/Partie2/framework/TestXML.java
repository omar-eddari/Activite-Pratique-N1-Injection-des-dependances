package Partie2.framework;

import Partie2.framework.xml.BeanDefinitionParser;
import Partie2.framework.xml.Beans;
import Partie2.framework.xml.XmlBeanDefinitionReader;

public class TestXML {
    public static void main(String[] args) {

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader();
        Beans beans = reader.loadBeans("config.xml");

        BeanDefinitionParser parser = new BeanDefinitionParser();
        var definitions = parser.parse(beans);

        definitions.forEach(System.out::println);
    }
}
