package com.bosssoft.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.IOException;

/**
 * @author 吴志鸿
 * @date 2020/7/14
 * @description 对入参的json进行转义
 */
public class JsonHtmlXssDeserializer extends JsonDeserializer<String> {

    public JsonHtmlXssDeserializer() {
        super();
    }

    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getValueAsString();
        if (value != null) {
            return StringEscapeUtils.escapeHtml4(value);
        }
        return value;
    }
}
