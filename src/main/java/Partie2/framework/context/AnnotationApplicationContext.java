package Partie2.framework.context;

import Partie2.framework.annotation.Inject;

import java.util.*;

public class AnnotationApplicationContext {

    private Map<Class<?>, Object> beans = new HashMap<>();

    public AnnotationApplicationContext(String... packageNames) {
        try {
            AnnotationScanner scanner = new AnnotationScanner();
            Set<Class<?>> classes = new HashSet<>();

            // 🔥 Scan multiple packages
            for (String pkg : packageNames) {
                classes.addAll(scanner.scan(pkg));
            }

            // 🧩 Step 1 — Instantiate beans
            for (Class<?> clazz : classes) {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                beans.put(clazz, instance);
            }

            // 🧩 Step 2 — Inject dependencies
            for (Class<?> clazz : classes) {
                Object bean = beans.get(clazz);

                for (var field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Inject.class)) {

                        Object dependency = findBeanByType(field.getType());

                        field.setAccessible(true);
                        field.set(bean, dependency);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Object findBeanByType(Class<?> type) {
        for (Object bean : beans.values()) {
            if (type.isAssignableFrom(bean.getClass())) {
                return bean;
            }
        }
        throw new RuntimeException("No bean found for type: " + type);
    }

    public <T> T getBean(Class<T> type) {
        return type.cast(findBeanByType(type));
    }
}