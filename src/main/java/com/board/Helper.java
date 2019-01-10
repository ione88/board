package com.board;

import java.util.ArrayList;

public class Helper {
    public static boolean isEmpty(String[] array) {
        if (array == null || array.length == 0) {
            return true;
        }
        return false;
    }
    public static boolean isEmpty(ArrayList<String> array) {
        if (array == null || array.size() == 0) {
            return true;
        }
        return false;
    }
}
