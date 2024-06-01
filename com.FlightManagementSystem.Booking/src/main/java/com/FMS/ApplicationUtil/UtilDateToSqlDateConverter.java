package com.FMS.ApplicationUtil;

import org.springframework.core.convert.converter.Converter;

public class UtilDateToSqlDateConverter implements Converter<java.util.Date, java.sql.Date> {

    @Override
    public java.sql.Date convert(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }
}