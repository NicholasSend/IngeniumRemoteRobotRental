package com.ingenium.double3rental;

import com.ingenium.double3rental.entities.*;
import com.ingenium.double3rental.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJdbcHttpSession
public class Sysc4907ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sysc4907ProjectApplication.class, args);
    }

    /**
     * Creates a demo version of the system
     * <p>
     * NOTE: Comment out @Bean below to remove the functionality
     *
     * @param repository the system repository
     * @return CommandLineRunner
     * @author Nicholas Sendyk, 101143602
     */
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {

            // Generate passwords
            String passwordHash1 = new BCryptPasswordEncoder().encode("Password1");
            String passwordHash2 = new BCryptPasswordEncoder().encode("Password2");

            // Generate Users
            User user1 = new User("User1", passwordHash1);
            User user2 = new User("User2", passwordHash2);

            // Generate Surveys
            RentalSession rentalSession = new RentalSession(0,0);
            RentalSession rentalSession1 = new RentalSession(10, 0);
            RentalSession rentalSession2 = new RentalSession(0, 1);
            RentalSession rentalSession3 = new RentalSession(20, 30);

            // Add sessions to users
            user1.addRentalSession(rentalSession);
            user1.addRentalSession(rentalSession1);
            user2.addRentalSession(rentalSession2);
            user2.addRentalSession(rentalSession3);

            repository.save(user1);
            repository.save(user2);

        };
    }

    /**
     * Bean that initializes session tables for the database.
     *
     * @param dataSource Data source to populate
     * @return Initializer
     */
    @Bean
    public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("/db/recreate-session-tables.sql"));
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }

}
