Camel ActiveMQ Project
======================

This project embeds Apache ActiveMQ together with Apache Camel.

To build this project use

    mvn install

To run this project

    mvn camel:run

To run this project on JBoss Fuse shell :

    -  create a properties file named camel.activemq.spring.conf in etc folder of JBoss Fuse containing ActiveMQ
      connection options, i.e :

      broker.url       = tcp://localhost:61616
      broker.username  = admin
      broker.password  = admin
      
    - install dependencies from Fuse shell:
	
	  features:install activemq-camel
	  features:install camel-gson

    - install the bundle from Fuse shell

      install -s mvn:com.mycompany/camel-activemq-blueprint/1.0.0-SNAPSHOT

For more general help see the Apache Camel documentation

    http://camel.apache.org/
    
For more help on ActiveMQ Camel component see the Apache Camel documentation for ActiveMQ

	http://camel.apache.org/activemq.html
	
	
	
	

restConfiguration().component("jetty").host("localhost").port(9090);
				
rest("/restcomm/2012-04-24").consumes("application/x-www-form-urlencoded,applicat/json")
.post("/Accounts/{AccountSid}/SMS/Messages/").to("direct:add")
exchange.getOut().setBody( Response.status(Response.Status.NO_CONTENT).build() );
			
