package pl.kamilszustak.labsoapjava.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kamilszustak.labsoapjava.schemas.api.RegisterCallRequest;
import pl.kamilszustak.labsoapjava.schemas.api.RegisterCallResponse;
import pl.kamilszustak.labsoapjava.schemas.api.ResultsRequest;
import pl.kamilszustak.labsoapjava.schemas.api.ResultsResponse;

@Component
public class SoapClient {
    private final SoapConnector soapConnector;

    @Autowired
    public SoapClient(SoapConnector soapConnector) {
        this.soapConnector = soapConnector;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void sendRequests() {
        sendRegisterCallRequest();
        sendResultsRequest();
    }

    private void sendRegisterCallRequest() {
        RegisterCallRequest request = new RegisterCallRequest();
        request.setStudent("John Smith");

        RegisterCallResponse response = (RegisterCallResponse) soapConnector.call(request);
        if (response != null) {
            System.out.println("REGISTER CALL");
            System.out.println("Name: " + response.getExercise().getName());
            System.out.println("Note: " + response.getExercise().getName());
            System.out.println();
        }
    }

    private void sendResultsRequest() {
        ResultsRequest request = new ResultsRequest();
        request.setStudent("John Smith");

        ResultsResponse response = (ResultsResponse) soapConnector.call(request);
        if (response != null) {
            System.out.println("RESULTS");
            for (String entry : response.getEntry()) {
                System.out.println("Entry: " + entry);
            }
        }
    }
}
