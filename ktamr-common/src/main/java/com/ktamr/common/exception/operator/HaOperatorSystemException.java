package com.ktamr.common.exception.operator;

/**
 * 用户不存在异常类
 * 
 * @author ktamr
 */
public class HaOperatorSystemException extends HaOperatorException
{
    private static final long serialVersionUID = 1L;

    public HaOperatorSystemException()
    {
        super("operator.system", null);
    }
}
