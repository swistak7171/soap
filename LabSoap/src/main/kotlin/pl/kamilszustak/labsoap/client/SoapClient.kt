package pl.kamilszustak.labsoap.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.kamilszustak.labsoap.schemas.api.RegisterCallRequest
import pl.kamilszustak.labsoap.schemas.api.RegisterCallResponse
import pl.kamilszustak.labsoap.schemas.api.ResultsRequest
import pl.kamilszustak.labsoap.schemas.api.ResultsResponse

@Component
class SoapClient @Autowired constructor(
    private val soapConnector: SoapConnector
) {
    init {
        sendRegisterCallRequest()
        sendResultsRequest()
    }

    private fun sendRegisterCallRequest() {
        val request = RegisterCallRequest().apply {
            this.student = "John Smith"
        }

        val response = soapConnector.call(request) as? RegisterCallResponse
        if (response != null) {
            println("REGISTER CALL")
            println("Name: ${response.exercise.name}")
            println("Note: ${response.exercise.note}")
            println()
        }
    }

    private fun sendResultsRequest() {
        val request = ResultsRequest().apply {
            this.student = "John Smith"
        }

        val response = soapConnector.call(request) as? ResultsResponse
        if (response != null) {
            println("RESULTS")
            println("Entry: ${response.entry}")
            println()
        }
    }
}