package com.kh.jaManChw.chat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class ChatConfig implements WebSocketMessageBrokerConfigurer{
//public class ChatConfig implements WebSocketConfigurer{

//	@Autowired ChatHendler chatHendler;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		logger.info("test");
//		registry
//		.addHandler(chatHendler, "/websocket")
//		.addInterceptors(new HttpSessionHandshakeInterceptor())
//		.setAllowedOriginPatterns("*").withSockJS();
//	}
//	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		registry.addEndpoint("/chat").setAllowedOriginPatterns("http://192.168.10.30:8888").withSockJS();
	}
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/pub");
        registry.enableSimpleBroker("/sub");
    }
}
