package Partie2.framework.context;

import Partie2.framework.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.*;

public class AnnotationScanner {

    public Set<Class<?>> scan(String packageName) {
        Set<Class<?>> classes = new HashSet<>();

        String path = packageName.replace('.', '/');

        URL resource = Thread.currentThread()
                .getContextClassLoader()
                .getResource(path);

        if (resource == null) {
            throw new RuntimeException("Package not found: " + packageName);
        }

        File directory;
        try {
            directory = new File(resource.toURI());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        File[] files = directory.listFiles();

        if (files == null) {
            throw new RuntimeException("No files found in: " + packageName);
        }

        if (!directory.exists() || directory.listFiles() == null) {
            throw new RuntimeException("Invalid directory for package: " + packageName);
        }

        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(".class")) {
                try {
                    String className = packageName + "." +
                            file.getName().replace(".class", "");

                    Class<?> clazz = Class.forName(className);

                    if (clazz.isAnnotationPresent(
                           Component.class)) {

                        classes.add(clazz);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return classes;
    }
}