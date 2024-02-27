package org.cssa.admin.config;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import org.cssa.admin.util.AdminServiceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminServiceInterceptor()).addPathPatterns("/admin/*").excludePathPatterns("/admin/login").excludePathPatterns("/admin/register");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        FastJsonConfig fastJsonConfig = getFastJsonConfig();
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(0, fastJsonHttpMessageConverter);
    }

    private static FastJsonConfig getFastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastJsonConfig.setWriterFeatures(
                JSONWriter.Feature.WriteNullListAsEmpty,
                JSONWriter.Feature.PrettyFormat,
                JSONWriter.Feature.WriteMapNullValue,
                JSONWriter.Feature.WriteLongAsString,
                JSONWriter.Feature.WriteNullBooleanAsFalse,
                JSONWriter.Feature.WriteNullListAsEmpty,
                JSONWriter.Feature.WriteNullNumberAsZero,
                JSONWriter.Feature.WriteNullStringAsEmpty,
                JSONWriter.Feature.MapSortField
        );
        fastJsonConfig.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return fastJsonConfig;
    }
}