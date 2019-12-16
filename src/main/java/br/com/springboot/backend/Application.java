package br.com.springboot.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final ZipCodeService zipCodeService;

    public Application(ZipCodeService zipCodeService) {
        this.zipCodeService = zipCodeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ZipCode zipCode = zipCodeService.findJsonBy("71936000");
        logger.info("JSON: {}", zipCode);

        zipCode = zipCodeService.findXmlBy("71936000");
        logger.info("XML: {}", zipCode);
    }
}
