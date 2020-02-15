package com.buy.fish.common.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName EnumConvertFactory
 * @Description 枚举转化工厂
 * @Author xinjiakun
 * @Date 2020/2/15 21:10
 */
@Component
@SuppressWarnings("all")
public class EnumConvertFactory implements ConverterFactory<String, BaseEnum> {
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> aClass) {
        return new IntegerToBaseEnum<T>(aClass);
    }

    private static class IntegerToBaseEnum<T extends BaseEnum> implements Converter<String, T> {

        private Class<T> targerType;

        public IntegerToBaseEnum(Class<T> targerType) {
            this.targerType = targerType;
        }

        @Override
        public T convert(String code) {
            return EnumConvertFactory.getIEnum(this.targerType, code);
        }
    }

    public static <T extends BaseEnum> T getIEnum(Class<T> targerType, String source) {
        for (T obj : targerType.getEnumConstants()) {
            if (source.equals(String.valueOf(obj.getCode()))) {
                return obj;
            }
        }
        return null;
    }
}
