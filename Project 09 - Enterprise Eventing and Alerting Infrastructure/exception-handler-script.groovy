import com.sap.it.api.msg.Message
import groovy.json.JsonOutput

def Message processErrorData(Message message) {
    def map = message.getProperties()
    def exceptionObj = map.get("CamelExceptionCaught")

    String errorMessage = "Unknown Platform Runtime Failure"
    String failedStepId = "Unknown_Integration_Step"

    if (exceptionObj != null) {
        errorMessage = exceptionObj.getMessage() ?: exceptionObj.toString()
        failedStepId = map.get("CamelFailureRouteId") ?: "Gateway_Router_Node"
    }

    def alertPayload = [
            Event_Header: [
                    EventID: "EVT-" + UUID.randomUUID().toString().substring(0,8).toUpperCase(),
                    EventType: "INTEGRATION_PIPELINE_ERROR",
                    Severity: "CRITICAL"
            ],
            Failure_Context: [
                    TargetSystem: "SAP_B1if_Cloud_Gateway",
                    FailedStepIdentifier: failedStepId,
                    ErrorMessageDetails: errorMessage
            ],
            System_Metadata: [
                    TenantID: "Matharsa_BTP_Trial_Tenant_AP21",
                    Timestamp: new Date().format("yyyy-MM-dd'T'HH:mm:ss'Z'", TimeZone.getTimeZone("UTC"))
            ]
    ]

    message.setBody(JsonOutput.toJson(alertPayload))
    message.setHeader("Content-Type", "application/json")
    message.setHeader("X-Alert-Event-Priority", "High")

    return message
}
