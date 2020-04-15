package pl.kamilszustak.labsoapjava.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pl.kamilszustak.labsoapjava.client.SoapConnector;

@Configuration
public class SoapConfiguration {
    @Bean
    public Jaxb2Marshaller getJaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("pl.kamilszustak.labsoapjava.schemas.api");

        return marshaller;
    }

    @Bean
    public SoapConnector getSoapConnector(Jaxb2Marshaller marshaller) {
        SoapConnector connector = new SoapConnector();
        connector.setDefaultUri("http://localhost:8080/soap");
        connector.setMarshaller(marshaller);
        connector.setUnmarshaller(marshaller);

        return connector;
    }
}
