//package io.swagger.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableWebSecurity
//@EnableSwagger2
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	private static final String[] AUTH_WHITELIST = {
//
//			// -- swagger ui
//			"/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**" };
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll();
//	}
//
//	ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("Swagger - Spring ").description("Aplicação spring boot + spring security + swagger")
//				.license("").licenseUrl("http://unlicense.org").termsOfServiceUrl("").version("1.0.0")
//				.contact(new Contact("", "", "")).build();
//	}
//
////	@Bean
////	public Docket customImplementation() {
////		return new Docket(DocumentationType.SWAGGER_2).select()
////				.apis(RequestHandlerSelectors.basePackage("br.com.tomCat.controllers")).build()
////				.directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
////				.directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class).apiInfo(apiInfo());
////	}
//
//	@Bean
//	public Docket apiDocket() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("br.com.tomCat.controllers")).paths(PathSelectors.any())
//				.build().directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
//				.directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class).apiInfo(apiInfo());
//	}
//
//}
