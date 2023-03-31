package com.generation.kodeco.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Kod-Eco")
						.description("Projeto Integrador - Generation Brasil")
						.version("v0.0.1")
						.license(new License()
						.name("Generation Brasil")
						.url("https://brazil.generation.org/"))
						.contact(new Contact()
						.name("Grupo 03 | Kod-Eco")
						.url("https://github.com/Diegorossato")
						.url("https://github.com/GabCopriva")
						.url("https://github.com/giufaria")
						.url("https://github.com/AmorimGuilherme")
						.url("https://github.com/thainasilvalima")
						.url("https://github.com/paradiseinlost")
						.email("projetofinalint03@gmail.com")))
						.externalDocs(new ExternalDocumentation()
						.description("Projeto Integrador | Kod-Eco")
						.url("https://github.com/AmorimGuilherme/Blog-Pessoal-Gen"));
	}

	@Bean
	public OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}

}