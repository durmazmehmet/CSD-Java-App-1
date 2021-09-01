package org.csystem.sample;

import org.csystem.sample.websockethandler.DeviceServerHandler;
import org.csystem.sample.websockethandler.UpperServerHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@SpringBootApplication
@EnableWebSocket
public class WebConfigurerApp implements WebSocketConfigurer {
    public static void main(String [] args)
    {
        SpringApplication.run(WebConfigurerApp.class, args);
    }

    @Bean
    public UpperServerHandler upperServerHandler()
    {
        return new UpperServerHandler();
    }
    @Bean
    public DeviceServerHandler deviceServerHandler()
    {
        return new DeviceServerHandler();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry)
    {
        webSocketHandlerRegistry.addHandler(upperServerHandler(), "/upper").setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(deviceServerHandler(), "/device").setAllowedOrigins("*");
    }
}
