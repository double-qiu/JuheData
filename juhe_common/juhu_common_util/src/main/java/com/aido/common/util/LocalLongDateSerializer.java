package com.aido.common.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * yyyy年MM月dd日  HH时mm分ss秒长格式时间序列化器
 *
 */
public class LocalLongDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
		String formattedDate = formatter.format(value);
		jgen.writeString(formattedDate);
	}
	
	
}
