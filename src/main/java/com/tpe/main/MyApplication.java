package com.tpe.main;

import com.tpe.AppConfig;
import com.tpe.service.MessageService;
import com.tpe.thirdparty.ThirdPartyComponent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {

    public static void main(String[] args) {

       //When you run the application Spring Container scan all the classes under the base package(com.tpe) with the @Component annotation.
       // if it finds any class with the Component annotation, Spring IOC Container creates a Bean and put the bean into Spring Container
       //then you can get the Bean that You want by using context.getBean method.

        //Spring Container == ApplicationContext

        //Step3
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        //Step 4
        MessageService service= context.getBean("mailService", MessageService.class);

        String message= service.sendMessage();
        System.out.println(message);


        ThirdPartyComponent thirdPartyComponent= context.getBean("thirdPartyComponent", ThirdPartyComponent.class);

        System.out.println(thirdPartyComponent.getMessage());


        context.close();

    }
}
