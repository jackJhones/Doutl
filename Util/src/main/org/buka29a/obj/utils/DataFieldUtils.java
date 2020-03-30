package org.buka29a.obj.utils;

import java.util.Set;
import java.util.stream.Collectors;

public final class DataFieldUtils {

    public static String normalizeName(String name) {
        return name.replaceAll("_", "");
    }

    public static Set<String> normalizeNames(Set<String> names) {
        return names.stream().map(DataFieldUtils::normalizeName).collect(Collectors.toSet());
    }
}
