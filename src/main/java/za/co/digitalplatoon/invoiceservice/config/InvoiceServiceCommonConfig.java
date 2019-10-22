package za.co.digitalplatoon.invoiceservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class InvoiceServiceCommonConfig {

    @Bean
    public Docket invoiceServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("invoiceService")
                .select()
                .apis(RequestHandlerSelectors.basePackage("za.co.digitalplatoon.invoiceservice.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
