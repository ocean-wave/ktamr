package com.ktamr.util;

import com.ktamr.common.utils.StringUtils;
import com.ktamr.common.utils.bean.BeanUtils;
import com.ktamr.domain.HaOperator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class Tool {

    public static Date RiQiZhuanHua(Object xx){
        Date start=null;
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );

        if(xx!=null){
            try {
                 start = sdf.parse(String.valueOf(xx));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return start;
    }
}
