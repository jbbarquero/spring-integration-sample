package com.malsolo.springframework.integration.sample.mail;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/integration/mail/spring-integration-context-imap.xml");
        DirectChannel inputChannel = context.getBean("receiveChannel", DirectChannel.class);
        inputChannel.subscribe((m) -> LOGGER.info("Message: " + m));
        System.out.println("Hit Enter to terminate");
        System.in.read();
        context.close();
        System.exit(0);
    }

}
