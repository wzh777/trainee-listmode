package com.bosssoft.filter;

import com.bosssoft.util.JsoupUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


import java.io.IOException;

/**
 * @author 吴志鸿
 * @date 2020/7/14
 * @description
 */
public class JsonHtmlXssDeserializer extends JsonSerializer<String> {

    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            String encodedValue = JsoupUtil.clean(value);
            jsonGenerator.writeString(encodedValue);
        }
    }

}
