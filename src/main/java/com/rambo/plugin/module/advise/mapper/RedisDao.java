package com.rambo.plugin.module.advise.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.function.Supplier;

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    public void setKey(String key,String value){
        ValueOperations<String,String> ops = template.opsForValue();

        ops.set(key,value);
    }

    public Supplier<String> getValue(String key){
        ValueOperations<String,String> ops = template.opsForValue();
        Supplier supplier = () -> ops.get(key);
        return supplier;
    }

}
