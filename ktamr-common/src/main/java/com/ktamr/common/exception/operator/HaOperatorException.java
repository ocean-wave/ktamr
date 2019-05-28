package com.ktamr.common.exception.operator;


import com.ktamr.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author ktamr
 */
public class HaOperatorException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public HaOperatorException(String code, Object[] args)
    {
        super("operator", code, args, null);
    }
}
