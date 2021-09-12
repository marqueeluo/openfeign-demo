package com.luo.demo.openfeign.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 转换解析器
 *
 * @author luohq
 * @date 2021-09-11
 */
@Configuration
public class MappingConverterAdapter {

    @Bean
    public Converter<String, LocalDate> DateConvert() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        };
    }
}