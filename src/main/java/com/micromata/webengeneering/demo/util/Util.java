package com.micromata.webengeneering.demo.util;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class Util {

//	@Autowired
//	Environment environment;
	
	public String getCurrentHostAndPort() {
		String rValue = "";
		
		// Port
//	    String port = environment.getProperty("server.port");
	    
		// Remote address
	    String address = InetAddress.getLoopbackAddress().getHostAddress();
	    System.out.println("address: " + address);
	    InetAddress.getLoopbackAddress().getHostName();
//		System.out.println("port: " + port);
		return rValue;
	}
}
