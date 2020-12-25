package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串->日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        //判断
        if(s == null){
            throw new RuntimeException("请输入数据");
        }
        //这里是jsp接口中输入的日期形式
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
