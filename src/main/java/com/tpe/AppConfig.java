package com.tpe;

import com.tpe.thirdparty.ThirdPartyComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//Step 1
@Configuration

//Step 2
@ComponentScan("com.tpe")

@PropertySource("classpath:application.properties")
//if you scan another packages to find the Component you can give a parameter into @ComponentScan annotation
public class AppConfig {


    //In order to get a bean with the context.getBean method you have to use method name for the parameter.
    @Bean
    public ThirdPartyComponent thirdPartyComponent(){
        return new ThirdPartyComponent();
    }


}
