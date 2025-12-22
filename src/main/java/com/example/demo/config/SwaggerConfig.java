package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Stock Portfolio Risk Analyzer API",
        version = "1.0"
    ),
    servers = {
        @Server(
            url = "https://9092.408procr.amypo.ai",
            description = "Public Tunnel Server"
        )
    }
)
public class SwaggerConfig {
}
