package com.bosssoft.config;

import com.bosssoft.util.JsonHtmlXssDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;
import java.util.ListIterator;

/**
 * @author 吴志鸿
 * @date 2020/7/14
 * @description
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 重写extendMessageConverters，此方法注释说就是让来修改已经配置好的转化器列表
     * 我们只需要遍历列表，找到MappingJackson2HttpMessageConverter
     * 我们可以根据类型来判断哪个是 MappingJackson2HttpMessageConverter 然后移除（注意遍历移除一定要用迭代器）
     * 最后把自定义的添加进去就好了
     */


    /**
     * 替换默认的MappingJackson2HttpMessageConverter，过滤(json请求参数)xss
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
        ListIterator<HttpMessageConverter<?>> listIterator = converters.listIterator();
        while (listIterator.hasNext()) {
            HttpMessageConverter<?> next = listIterator.next();
            if (next instanceof MappingJackson2HttpMessageConverter) {
                listIterator.remove();
                break;
            }
        }
        converters.add(getMappingJackson2HttpMessageConverter());
    }

    private MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        // 创建自定义ObjectMapper
        SimpleModule module = new SimpleModule();
        module.addDeserializer(String.class, new JsonHtmlXssDeserializer());
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(this.getApplicationContext()).build();
        objectMapper.registerModule(module);

        // 创建自定义消息转换器
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        return mappingJackson2HttpMessageConverter;
    }
}
