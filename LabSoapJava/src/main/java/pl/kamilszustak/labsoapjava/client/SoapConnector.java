package pl.kamilszustak.labsoapjava.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapConnector extends WebServiceGatewaySupport {
    @Value("${base-url}")
    private String baseUrl;

    public Object call(Object request) {
        return getWebServiceTemplate().marshalSendAndReceive(baseUrl, request);
    }
}
