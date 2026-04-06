package framework;

import framework.xml.BeanDefinitionParser;
import framework.xml.Beans;
import framework.xml.XmlBeanDefinitionReader;

public class TestXML {
    public static void main(String[] args) {

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader();
        Beans beans = reader.loadBeans("config.xml");

        BeanDefinitionParser parser = new BeanDefinitionParser();
        var definitions = parser.parse(beans);

        definitions.forEach(System.out::println);
    }
}
