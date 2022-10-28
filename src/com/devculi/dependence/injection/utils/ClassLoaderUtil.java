package com.devculi.dependence.injection.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassLoaderUtil {

    private static final String DOT = ".";
    private static final String FORWARD_SLASH = "/";
    private static final String CLASS = ".class";
    private static final String EMPTY = "";

    private ClassLoaderUtil() {}

    public static List<Class<?>> getClasses(String mainPackageName)
            throws IOException, ClassNotFoundException {
        String path = mainPackageName.replace(DOT, FORWARD_SLASH);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(path);
        String fileName = resource.getFile();
        File file = new File(fileName);
        return findClass(file, mainPackageName);
    }

    private static List<Class<?>> findClass(File file, String packageName)
            throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!file.getName().endsWith(CLASS)) {
            File[] files = file.listFiles();
            if (files != null && files.length != 0) {
                for (int index = 0; index < files.length; index++) {
                    String packageNameJoined =
                            String.join(DOT, packageName, files[index].getName());
                    findClass(files[index], packageNameJoined);
                }
            }
        } else {
            if (packageName.contains(CLASS)) {
                String packageNameReplaced = packageName.replace(CLASS, EMPTY);
                Class clazz = Class.forName(packageNameReplaced);
                classes.add(clazz);
            }
        }
        classes.stream().forEach(clazz -> System.out.println(clazz.getName()));
        return classes;
    }
}
