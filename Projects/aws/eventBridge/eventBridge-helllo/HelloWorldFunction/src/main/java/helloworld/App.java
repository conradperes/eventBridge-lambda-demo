package helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import model.aws.ec2.AWSEvent;
import model.aws.ec2.EC2InstanceStateChangeNotification;
import model.aws.ec2.marshaller.Marshaller;
import com.amazonaws.services.eventbridge.AmazonEventBridgeClient;
import com.amazonaws.services.eventbridge.model.PutEventsRequest;
import com.amazonaws.services.eventbridge.model.PutEventsRequestEntry;
import com.amazonaws.services.eventbridge.model.PutEventsResult;
import com.amazonaws.services.eventbridge.model.PutEventsResultEntry;
/**
 * Handler for EventBridge invocations of a Lambda function target
 */
public class App implements RequestStreamHandler {

    static final String NEW_DETAIL_TYPE = "HelloWorldFunction updated event of %s";

    private Object handleEvent(final AWSEvent<EC2InstanceStateChangeNotification> inputEvent, final Context context) {
        if (inputEvent != null) {
            EC2InstanceStateChangeNotification detail = inputEvent.getDetail();

            //Developers write your event-driven business logic code here!
            inputEvent.setDetailType(String.format(NEW_DETAIL_TYPE, inputEvent.getDetailType()));

            return inputEvent;
        }

        throw new IllegalArgumentException("Unable to deserialize lambda input event to AWSEvent<EC2InstanceStateChangeNotification>. Check that you have the right schema and event source.");
    }

    /**
     * Handles a Lambda Function request
     * @param input The Lambda Function input stream
     * @param output The Lambda function output stream
     * @param context The Lambda execution environment context object.
     * @throws IOException
     */
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        AWSEvent<EC2InstanceStateChangeNotification> event = Marshaller.unmarshalEvent(input, EC2InstanceStateChangeNotification.class);

        Object response = handleEvent(event, context);

        Marshaller.marshal(output, response);
    }

    public void putEvent(AWSEvent<EC2InstanceStateChangeNotification> event ){

        PutEventsRequestEntry requestEntry = new PutEventsRequestEntry()
                .withTime(new java.util.Date())
                .withSource("com.mycompany.myapp")
                .withDetailType("myDetailType")
                .withResources("resource1", "resource2")
                .withDetail("{ \"key1\": \"value1\", \"key2\": \"value2\" }");

        PutEventsRequest request = new PutEventsRequest()
                .withEntries(requestEntry, requestEntry);

//        PutEventsResult result = event.putEvents(request);
//        for (PutEventsResultEntry resultEntry : result.getEntries()) {
//            if (resultEntry.getEventId() != null) {
//                System.out.println("Event Id: " + resultEntry.getEventId());
//            } else {
//                System.out.println("Injection failed with Error Code: " + resultEntry.getErrorCode());
//            }
//        }
    }
}
