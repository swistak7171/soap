package pl.kamilszustak.labsoap.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.ws.client.core.support.WebServiceGatewaySupport

class SoapConnector : WebServiceGatewaySupport() {
    @Value("\${base-url}")
    private lateinit var baseUrl: String

    fun callService(request: Any): Any? =
        webServiceTemplate.marshalSendAndReceive(baseUrl, request)
}