package br.edu.atitus.paradigma.api_gateway_service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

	@Bean
	RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
		       .route(rota -> rota
		    		   .path("/get")
		    		   .filters(f -> f
		    				   .addRequestHeader("Usuario", "Gabriel Gaio")
		    				   .addRequestHeader("Senha", "suaSenhaAqui")
		    				   .addRequestParameter("Parametros", "ValorParametro")
		    				   .addRequestHeader("Servidor", "meuServer"))
		    		   .uri("http://httpbin.org"))
		       .route(rota -> rota
		    		   .path("/cambio-service/**")
		    		   .filters(f -> f
		    				   .addRequestHeader("Usuario", "Gabriel Gaio")
		    				   .addRequestHeader("Senha", "suaSenhaAqui"))
		    		   .uri("lb://cambio-service"))
		       .route(rota -> rota
		    		   .path("/produto-service/**")
		    		   .filters(f -> f
		    				   .addRequestHeader("Usuario", "Gabriel Gaio")
		    				   .addRequestHeader("Senha", "suaSenhaAqui"))
		    		   .uri("lb://produto-service"))
		       .route(rota -> rota
		    		   .path("/saudacao-service/**")
		    		   .filters(f -> f
		    				   .addRequestHeader("Usuario", "Gabriel Gaio")
		    				   .addRequestHeader("Senha", "suaSenhaAqui"))
		    		   .uri("lb://saudacao-service"))
		       .build();
	}
}
