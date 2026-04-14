package Partie2.framework.context;

import Partie2.framework.core.BeanDefinition;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContextConstructorInjection {

    private Map<String, Object> beans = new HashMap<>();

    public ApplicationContextConstructorInjection(List<BeanDefinition> definitions) {
        try {
            for (BeanDefinition bd : definitions) {

                Class<?> clazz = Class.forName(bd.getClassName());
                Object instance = null;

                if (bd.getConstructorArgs() != null && !bd.getConstructorArgs().isEmpty()) {

                    Object[] args = new Object[bd.getConstructorArgs().size()];

                    for (int i = 0; i < args.length; i++) {
                        args[i] = beans.get(bd.getConstructorArgs().get(i).getRef());
                    }

                    // 🔥 Find compatible constructor
                    for (Constructor<?> constructor : clazz.getConstructors()) {

                        Class<?>[] paramTypes = constructor.getParameterTypes();

                        if (paramTypes.length == args.length) {

                            boolean match = true;

                            for (int i = 0; i < paramTypes.length; i++) {
                                if (!paramTypes[i].isAssignableFrom(args[i].getClass())) {
                                    match = false;
                                    break;
                                }
                            }

                            if (match) {
                                instance = constructor.newInstance(args);
                                break;
                            }
                        }
                    }

                    if (instance == null) {
                        throw new RuntimeException("No matching constructor found for " + bd.getId());
                    }

                } else {
                    instance = clazz.getDeclaredConstructor().newInstance();
                }
                beans.put(bd.getId(), instance);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String id) {
        return beans.get(id);
    }
}
