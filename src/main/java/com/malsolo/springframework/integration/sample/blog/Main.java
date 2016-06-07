package com.malsolo.springframework.integration.sample.blog;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        final AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/integration/blog/*-context.xml");

        context.registerShutdownHook();

        System.out.println("Hit Enter to terminate");
        System.in.read();
        context.close();
        System.exit(0);
    }

}
