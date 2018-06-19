package com.test;

import org.apache.camel.Exchange;
import org.apache.camel.spi.ExchangeFormatter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "logFormatter")
@Scope(value = "prototype")
public class MyExchangeFormatter implements ExchangeFormatter {

	private static final String SEPARATOR = "|";

	private String msg;
	
	@Override
	public String format(Exchange ex) {
		StringBuilder sb = new StringBuilder();
		sb.append(getProp(ex, "prop1")).append(SEPARATOR);
		sb.append(getProp(ex, "prop2")).append(SEPARATOR);
		sb.append(getProp(ex, "prop3")).append(SEPARATOR);
		sb.append(getMsg());
		return sb.toString();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	private String getProp(Exchange ex, String key) {
		String result = "";
		if (ex != null) {
			Object obj = ex.getProperty(key);
			if (obj != null)
				result = obj.toString();
		}
		return result;
	}

}
