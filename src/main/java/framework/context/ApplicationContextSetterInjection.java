package framework.context;

import framework.core.BeanDefinition;
import framework.core.Property;
import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContextSetterInjection {

    private Map<String, Object> beans = new HashMap<>();

    public ApplicationContextSetterInjection(List<BeanDefinition> definitions) {
        try {
            // Step 1: Instantiate all beans
            for (BeanDefinition bd : definitions) {
                Class<?> clazz = Class.forName(bd.getClassName());
                Object instance = clazz.getDeclaredConstructor().newInstance();
                beans.put(bd.getId(), instance);
            }

            // Step 2: Inject dependencies (Setter Injection)
            for (BeanDefinition bd : definitions) {
                Object bean = beans.get(bd.getId());

                if (bd.getProperties() != null) {
                    for (Property prop : bd.getProperties()) {
                        Object dependency = beans.get(prop.getRef());

                        // Build setter name
                        String setterName = "set" +
                                prop.getName().substring(0, 1).toUpperCase() +
                                prop.getName().substring(1);

                        // Find method
                        for (Method method : bean.getClass().getMethods()) {
                            if (method.getName().equals(setterName)
                                    && method.getParameterCount() == 1) {

                                method.invoke(bean, dependency);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String id) {
        return beans.get(id);
    }
}
