package com.eilabs.constant;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    private static List<ConstItem> data = new ArrayList<>();

    public static List<ConstItem> getData() {
        return data;
    }

    static {

        data.add(new ConstItem(10000, "Acceleration Due to Gravity","g =9.8 m/s2 "));

        data.add(new ConstItem(10001, "Pi", "3.141"));

        data.add(new ConstItem(10002, "G", "6.67"));

        data.add(new ConstItem(10003, "Plank Constant", "."));

        data.add(new ConstItem(10004, "Reflective Index", "."));

        data.add(new ConstItem(10005, "Alpha", "."));

        data.add(new ConstItem(10006, "Beta", "t."));

        data.add(new ConstItem(10007, "Theta", "."));


    }
}
