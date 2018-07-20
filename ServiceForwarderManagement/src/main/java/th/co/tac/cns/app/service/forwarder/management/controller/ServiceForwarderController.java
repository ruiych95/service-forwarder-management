package th.co.tac.cns.app.service.forwarder.management.controller;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import th.co.tac.cns.app.service.forwarder.management.ServiceForwarderManagementApplication;
import th.co.tac.cns.app.service.forwarder.management.model.InsufficientBalanceNotify;
import th.co.tac.cns.app.service.forwarder.management.util.XMLParser;

//@RestController
public class ServiceForwarderController 
{
//	@RequestMapping(value = "/forwarder", method = RequestMethod.POST, consumes = "text/xml")
	public void RevenuegetByKeyword(@RequestBody String insufficientBalanceNotify)
	{
		System.out.println(insufficientBalanceNotify);
		try 
		{
			InsufficientBalanceNotify request = XMLParser.unmarshal(insufficientBalanceNotify, InsufficientBalanceNotify.class);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		ConfigurableApplicationContext context = SpringApplication.run(ServiceForwarderManagementApplication.class);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new InsufficientBalanceNotify());
	}
	
//	@Bean
//	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
//			DefaultJmsListenerContainerFactoryConfigurer configurer) 
//	{
//		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//		// This provides all boot's default to this factory, including the message
//		// converter
//		configurer.configure(factory, connectionFactory);
//		// You could still override some of Boot's default if necessary.
//		return factory;
//	}
//
//	@Bean // Serialize message content to json using TextMessage
//	public MessageConverter jacksonJmsMessageConverter() 
//	{
//		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//		converter.setTargetType(MessageType.TEXT);
//		converter.setTypeIdPropertyName("_type");
//		return converter;
//	}
}
