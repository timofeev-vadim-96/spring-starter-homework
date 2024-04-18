package ru.gb.timerstarter;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.event.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Параметр с возможностью конфигурации стартера через application.yml
 */
@Getter
@Setter
@ConfigurationProperties(value = "timer.logging")
public class TimerLoggingProperties {

    /**
     * Уровень логирования таймера
     */
    private Level timerLogLevel = Level.INFO; //значение по умолчанию
}
