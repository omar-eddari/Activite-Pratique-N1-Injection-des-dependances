package framework.xml;

import framework.core.*;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinitionParser {

    public List<BeanDefinition> parse(Beans beans) {
        List<BeanDefinition> list = new ArrayList<>();
        List<ConstructorArg> args = new ArrayList<>();


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
                    bd.setProperties(props);
                }
            }
            if (beanConfig.getConstructorArgs() != null) {
                for (ConstructorArgConfig cac : beanConfig.getConstructorArgs()) {
                    ConstructorArg ca = new ConstructorArg();
                    ca.setRef(cac.getRef());
                    args.add(ca);
                    bd.setConstructorArgs(args);
                }
            }
            list.add(bd);
        }

        return list;
    }
}