package com.devculi.dependence.injection;

import java.io.IOException;
import com.devculi.dependence.injection.injector.CustomInjector;

public class DependenceInjectionApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CustomInjector.startApplication(DependenceInjectionApplication.class);
    }
}
