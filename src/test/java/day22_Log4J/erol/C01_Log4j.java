package day22_Log4J.erol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4j {
    @Test
    public void log4j() {
        Logger logger = LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");


    }
}

/*
erol hoca log4j2

?xml version="1.0" encoding="UTF-8"?>
<Configuration status="INFO">
    <Appenders><!--Log kayıtlarını Consola yazdırır -->
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
        </Console>
        <File name="File" fileName="selenium.log" append="true"><!--Logları test çalışırken ekler -->
            <PatternLayout pattern="%d{dd.MM.yyyy HH:mm:ss} %c %m%n" />
        </File>
    </Appenders>
    <Loggers><!--Hangi seviyede loglama yapılacağı belirtilir -->
        <Root level="INFO">
            <AppenderRef ref="Console" />
            <AppenderRef ref="File" />
        </Root>
    </Loggers>
</Configuration>
 */