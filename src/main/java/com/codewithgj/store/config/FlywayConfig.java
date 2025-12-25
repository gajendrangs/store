package com.codewithgj.store.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(DataSource dataSource) {
        // Build the Flyway instance using the primary DataSource
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                // Set the location explicitly to confirm the path
                .locations("classpath:db/migration")
                .load();

        // Run the migration immediately
        flyway.migrate();

        return flyway;
    }
}