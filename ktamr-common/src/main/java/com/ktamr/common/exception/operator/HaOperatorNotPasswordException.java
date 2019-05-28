package com.ktamr.common.exception.operator;

/**
 * 用户不存在异常类
 * 
 * @author ruoyi
 */
public class HaOperatorNotPasswordException extends HaOperatorException
{
    private static final long serialVersionUID = 1L;

    public HaOperatorNotPasswordException()
    {
        super("operator.not.password", null);
    }
}
