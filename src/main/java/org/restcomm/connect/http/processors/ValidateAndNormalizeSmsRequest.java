package org.restcomm.connect.http.processors;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.smpp.SmppConstants;
import org.apache.cxf.message.MessageContentsList;

public class ValidateAndNormalizeSmsRequest implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		MessageContentsList params =  (MessageContentsList) exchange.getIn().getBody();
		
		String accountSid					=	(String)params.get(0);
		MultivaluedMap<String, String> data	=	(MultivaluedMap<String, String>) params.get(1);
		MediaType contentType				=	(MediaType)params.get(2);
		
		validate(data);
		
		exchange.getIn().setHeader(SmppConstants.COMMAND, "SubmitSm");
        exchange.getIn().setHeader(SmppConstants.SOURCE_ADDR, data.getFirst("From"));
        exchange.getIn().setHeader(SmppConstants.DEST_ADDR, data.getFirst("To") );
        exchange.getIn().setBody(  data.getFirst("Body")  );
        
        //System.out.println( data.getFirst("Body")  );
		
	}//EO Processor
	
	
	private void validate(final MultivaluedMap<String, String> data) throws NullPointerException {
        if (!data.containsKey("From")) {
            throw new NullPointerException("From can not be null.");
        } else if (!data.containsKey("To")) {
            throw new NullPointerException("To can not be null.");
        } else if (!data.containsKey("Body")) {
            throw new NullPointerException("Body can not be null.");
        }
    }

}
