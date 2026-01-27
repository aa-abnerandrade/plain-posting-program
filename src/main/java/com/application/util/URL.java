package com.application.util;

import lombok.experimental.UtilityClass;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


@UtilityClass
public class URL {

  public static String decodeParam(String text) {
    return URLDecoder.decode(text, StandardCharsets.UTF_8);
  }

  public static Date convertStringParamToDate(String textDate, Date defaultDate) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    try {
      return sdf.parse(textDate);
    } catch (ParseException e) {
      return defaultDate;
    }
  }
}
