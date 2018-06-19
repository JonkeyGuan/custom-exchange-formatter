package com.test;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component(value = "myProcessor")
public class MyProcessor implements Processor {
	public void process(Exchange exchange) throws Exception {
		exchange.setProperty("prop1", "prop1");
		exchange.setProperty("prop2", "prop2");
		exchange.setProperty("prop3", "prop3");
	}
}
