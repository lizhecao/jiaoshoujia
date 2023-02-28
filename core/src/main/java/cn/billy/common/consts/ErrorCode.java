package cn.billy.common.consts;

/**
 * @author billyzcli
 * @date 2023/2/15
 */
public enum ErrorCode {
    ERROR(9999, "system error");
    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getStrCode() {
        return String.valueOf(code);
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 通过错误码获取code对象
     *
     * @param errorCode
     * @return
     */
    public static ErrorCode getCode(int errorCode) {
        for (ErrorCode c : ErrorCode.values()) {
            if (errorCode == c.getCode()) {
                return c;
            }
        }
        return ERROR;
    }
}
