package com.micromata.webengineering.demo.util;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class Util implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

	private int port;
	
	public String getCurrentHostAndPort() {
		String rValue = "";
		
		// Remote address
//	    String address = InetAddress.getLoopbackAddress().getHostAddress();
	    String name = InetAddress.getLoopbackAddress().getHostName();
	    rValue = "http://" + name + ":" + this.port;
		return rValue;
	}

	@Override
	public void onApplicationEvent(EmbeddedServletContainerInitializedEvent arg0) {
		// TODO Auto-generated method stub
		this.port = arg0.getSource().getPort();
	}
}