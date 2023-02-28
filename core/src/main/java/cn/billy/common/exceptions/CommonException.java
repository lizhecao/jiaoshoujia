package cn.billy.common.exceptions;

import cn.billy.common.consts.ErrorCode;

import java.text.MessageFormat;

/**
 * 
 * @author  xulong
 * @version  [2016年4月21日]
 */

public class CommonException extends RuntimeException{
    /**
     * serialVersionUID属性说明:
     */
    private static final long serialVersionUID = -4489863084588071581L;
    private int code;
    
    public CommonException(Throwable cause)
    {
      super(cause);
    }

    public CommonException(ErrorCode errorCode, Throwable cause)
    {
        super(errorCode.getMsg(), cause);
        setCode(errorCode.getCode());
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }
    public CommonException(ErrorCode errorCode, Object... arguments) {
        super(MessageFormat.format(errorCode.getMsg(), arguments));
        setCode(errorCode.getCode());
    }
    public CommonException(ErrorCode errorCode)
    {
      super(errorCode.getMsg());
      setCode(errorCode.getCode());
    }
    public CommonException(String message)
    {
      super(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
}
