package com.dmorozzov.timeobsrv;

import com.dmorozzov.timeobsrv.config.JpaConfig;
import com.dmorozzov.timeobsrv.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import({JpaConfig.class, SecurityConfig.class})
@SpringBootApplication(
		scanBasePackages={"com.dmorozzov.timeobsrv"},
		exclude = {SecurityAutoConfiguration.class})
public class TimeobsrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeobsrvApplication.class, args);
	}

}
