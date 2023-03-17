package com.wenxin.demo.util;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BeanUtils {
    public static MultiValueMap<String, String> beanToMap(Object bean) throws IllegalAccessException {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (Objects.nonNull(field.get(bean))) {
                map.add(field.getName(), String.valueOf(field.get(bean)));
            }
        }
        return map;
    }
}
