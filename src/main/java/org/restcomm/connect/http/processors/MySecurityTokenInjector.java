package org.restcomm.connect.http.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.lang.StringUtils;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class MySecurityTokenInjector implements Processor{

	public void process(Exchange exchange) throws Exception {
		
		String authHeader = (String)exchange.getIn().getHeader("Authorization");
		
        if (authHeader != null) {
            String[] parts = authHeader.split(" ");
            if (parts.length >= 2 && parts[0].equals("Basic")) {
                String base64Credentials = parts[1].trim();
                String credentials = new String(Base64.decodeBase64(base64Credentials), Charset.forName("UTF-8"));
                // credentials = username:password
                final String[] values = credentials.split(":",2);
                if (values.length >= 2) {
                	exchange.getIn().setHeader("SHIRO_SECURITY_USERNAME", values[0]);
                    exchange.getIn().setHeader("SHIRO_SECURITY_PASSWORD", values[1]);
                }

            }
        }
        
		
	}//EO processor

}