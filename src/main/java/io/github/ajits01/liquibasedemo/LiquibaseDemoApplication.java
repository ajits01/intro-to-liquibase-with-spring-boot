package io.github.ajits01.liquibasedemo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import liquibase.integration.spring.SpringLiquibase;

@SpringBootApplication
public class LiquibaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiquibaseDemoApplication.class, args);
	}

	/**
	 * Configure Liquibase to run Liquibase automatically when the Spring context is
	 * initialized.<br>
	 * Loads Database ChangeLog (master.xml) from the classpath and apply it against
	 * configured DataSource.
	 */
	@Bean
	public SpringLiquibase liquibase() {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:liquibase/master.xml");
		liquibase.setDataSource(dataSource());
		return liquibase;
	}

	/**
	 * Configure H2 Database DataSource <br>
	 * See repos README.md to setup simple persistent file based H2 DB
	 */
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		/** Connect using TCP server URL (See "Start H2 Server" in app README.md) */
		dataSourceBuilder.url("jdbc:h2:tcp://192.168.56.1:9092/appDB");
		dataSourceBuilder.username("sa");
		dataSourceBuilder.password("");
		return dataSourceBuilder.build();
	}
}
