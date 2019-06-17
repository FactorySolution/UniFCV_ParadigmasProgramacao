package br.edu.unifcv.faculdade.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket autorApi() {
		List<SecurityScheme> schemeList = new ArrayList<>();
		schemeList.add(new BasicAuth("basicAuth"));
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.edu.unifcv.faculdade"))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(schemeList);
	}

}
