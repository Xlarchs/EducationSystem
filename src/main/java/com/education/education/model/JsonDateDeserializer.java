package com.education.education.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

// start_date ve end_date sütunlarına veri eklemek için json parser
@Component
public class JsonDateDeserializer extends JsonDeserializer<Date> {
	// ISO 8601
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		try {
			return dateFormat.parse(jsonParser.getText());
		} catch (ParseException e) {
			return null;
		}
	}
}