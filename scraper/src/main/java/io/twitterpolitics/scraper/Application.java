package io.twitterpolitics.scraper;

import io.twitterpolitics.scraper.service.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAsync
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories("io.twitterpolitics.repository")
@ComponentScan("io.twitterpolitics.scraper.service")
@EntityScan("io.twitterpolitics.entity")
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private ScraperService scraperService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        scraperService.saveStatuses();
    }

}
