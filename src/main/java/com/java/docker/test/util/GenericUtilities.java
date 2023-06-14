package com.java.docker.test.util;

import java.util.List;

public class GenericUtilities {

    public static boolean isEmpty(List<?> list) {
        if (list == null) {
            return true;
        }
        return list.isEmpty();
    }

    public static <T> T getFirstItemFromList(List<T> list) {

        if (isEmpty(list)) {
            return null;
        }

        return list.get(0);

    }

    public static <T> T getFirstItemFromListThrows(List<T> list, RuntimeException e) throws RuntimeException {

        T t = getFirstItemFromList(list);

        if (t == null) {
            throw e;
        }

        return t;

    }


    public static boolean isEmpty(Object value) {
		return value == null || value.toString().equals("");
	}

    public static boolean isEmpty(String value) {
		return value == null || value.equals("");
	}


}
