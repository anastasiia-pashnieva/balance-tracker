package com.pashnieva.website.common.util;

import java.util.Objects;

public class StringUtils {

    private StringUtils() {}

    public static boolean isNotBlank(String string) {
        return Objects.nonNull(string) && !string.trim().isEmpty();
    }

    public static boolean matchesFormat(String string, String format) {
        return isNotBlank(string) && string.matches(format);
    }
}
