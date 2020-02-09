package com.buy.fish.common.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @ClassName RedisConverter
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/9 9:33
 */
public class RedisConverter implements RedisSerializer<Object> {
    private Converter<Object, byte[]> serializer = new SerializingConverter();//序列化器
    private Converter<byte[], Object> deserializer = new DeserializingConverter();//反序列化器

    public byte[] serialize(Object o) throws SerializationException {//对象序列化为字节数组
        if (o == null) return new byte[0];
        try {
            return serializer.convert(o);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public Object deserialize(byte[] bytes) throws SerializationException {//字节数组反序列化为对象
        if (bytes == null || bytes.length == 0) return null;
        try {
            return deserializer.convert(bytes);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
