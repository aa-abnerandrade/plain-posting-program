package com.application.util;

import lombok.experimental.UtilityClass;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;


@UtilityClass
public class URL {

  public static String decodeParam(String text) {
    return URLDecoder.decode(text, StandardCharsets.UTF_8);
  }
}
