package com.kh.jaManChw.chat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.kh.jaManChw.chat.hendler.ChatHendler;

@Configuration
@EnableWebSocket
public class ChatConfig implements WebSocketConfigurer{

	@Autowired ChatHendler chatHendler;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		logger.info("test");
		registry.addHandler(chatHendler, "/websocket/*").setAllowedOrigins("*");
	}

}
