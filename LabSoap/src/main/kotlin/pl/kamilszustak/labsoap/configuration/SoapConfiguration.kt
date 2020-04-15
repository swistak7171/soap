package pl.kamilszustak.labsoap.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import pl.kamilszustak.labsoap.client.SoapConnector

@Configuration
class SoapConfiguration {
    @Bean
    fun getJaxb2Marshaller(): Jaxb2Marshaller =
        Jaxb2Marshaller().apply {
            contextPath = "pl.kamilszustak.labsoap.schemas.api"
        }

    @Bean
    fun getSoapConnector(marshaller: Jaxb2Marshaller?): SoapConnector? =
        SoapConnector().apply {
            defaultUri = "http://localhost:8080/soap"
            setMarshaller(marshaller)
            unmarshaller = marshaller
        }
}