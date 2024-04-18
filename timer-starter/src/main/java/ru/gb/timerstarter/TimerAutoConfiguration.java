package ru.gb.timerstarter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TimerLoggingProperties.class)
public class TimerAutoConfiguration {

    @Bean
    TimerAspect createTimerAspect(TimerLoggingProperties timerLoggingProperties){
        return new TimerAspect(timerLoggingProperties);
    }
}
