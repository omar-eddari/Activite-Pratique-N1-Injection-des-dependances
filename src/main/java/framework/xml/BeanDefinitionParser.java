package framework.xml;

import framework.core.*;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinitionParser {

    public List<BeanDefinition> parse(Beans beans) {
        List<BeanDefinition> list = new ArrayList<>();

        for (BeanConfig beanConfig : beans.getBeans()) {
            BeanDefinition bd = new BeanDefinition();
            bd.setId(beanConfig.getId());
            bd.setClassName(beanConfig.getClassName());

            List<Property> props = new ArrayList<>();

            if (beanConfig.getProperties() != null) {
                for (PropertyConfig pc : beanConfig.getProperties()) {
                    Property p = new Property();
                    p.setName(pc.getName());
                    p.setRef(pc.getRef());
                    props.add(p);
                }
            }

            bd.setProperties(props);
            list.add(bd);
        }

        return list;
    }
}