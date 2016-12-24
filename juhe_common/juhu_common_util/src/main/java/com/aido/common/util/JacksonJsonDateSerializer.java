package com.aido.common.util;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 在使用jackson序列化时间时，时间会转成long类型，<br/>
 * 这样传到前端不易转换和处理，通过在相应的字段get方法上添加注解<br/>
 * "@JsonSerialize(using = JsonDateSerializer.class)"<br/>
 * 可以指定序列化时间格式为：yyyy-MM-dd HH:mm:ss
 * 
 * 
 * @author nibili 2015年4月16日
 * 
 */
public class JacksonJsonDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {

		String formattedDate = FormatConstants.DATE_TIME_FORMAT.format(date);

		gen.writeString(formattedDate);
	}

}
