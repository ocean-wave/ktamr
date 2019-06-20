package com.ktamr.common.utils;

import java.text.DecimalFormat;

public class DecimalUtils extends DecimalFormat {

    public static String FORMAT_ONE = "0";

    public static String FORMAT_TWO = "0.00";

    public static String decimal(double d){
        return new DecimalFormat(FORMAT_ONE).format(d);
    }

    public static String decimalTwo(double d){
        return new DecimalFormat(FORMAT_TWO).format(d);
    }
}
