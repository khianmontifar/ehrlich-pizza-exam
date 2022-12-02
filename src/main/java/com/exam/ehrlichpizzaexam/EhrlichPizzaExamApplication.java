/**
 * This PizzaOrder API program implements a functionality to import,
 * store and process csv files for pizza orders and provide an
 * insight as sales input.
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class EhrlichPizzaExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhrlichPizzaExamApplication.class, args);
	}

}
