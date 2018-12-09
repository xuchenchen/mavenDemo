package com.ryx.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {
    private String datePatter;

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(datePatter);
        try {
            return new Date();
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }


    public void setDatePatter(String datePatter) {
        this.datePatter = datePatter;
    }

    public String getDatePatter() {
        return datePatter;
    }
}
