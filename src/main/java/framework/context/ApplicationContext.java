package framework.context;

import framework.core.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {

    private Map<String, Object> beans = new HashMap<>();

    public ApplicationContext(List<BeanDefinition> definitions) {
        try {
            // Step 1: Instantiate all beans
            for (BeanDefinition bd : definitions) {
                Class<?> clazz = Class.forName(bd.getClassName());
                Object instance = clazz.getDeclaredConstructor().newInstance();
                beans.put(bd.getId(), instance);
            }

            // Step 2: Inject dependencies (Field injection for now)
            for (BeanDefinition bd : definitions) {
                Object bean = beans.get(bd.getId());

                if (bd.getProperties() != null) {
                    for (Property prop : bd.getProperties()) {
                        Object dependency = beans.get(prop.getRef());

                        Field field = bean.getClass().getDeclaredField(prop.getName());
                        field.setAccessible(true);
                        field.set(bean, dependency);
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
