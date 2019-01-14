package tech.wetech.admin.core.utils;

/**
 * @author cjbi
 */
public enum ResultCodeEnum {

<<<<<<< HEAD
    OK("200", "å¤„ç†æˆåŠŸ"),
    BAD_REQUEST("400", "è¯·æ±‚å‚æ•°æœ‰è¯¯"),
    UNAUTHORIZED("401", "æœªæŽˆæƒ"),
    PARAMS_MISS("483", "ç¼ºå°‘æŽ¥å£ä¸­å¿…å¡«å‚æ•°"),
    PARAM_ERROR("484", "å‚æ•°éžæ³•"),
    FAILED_DEL_OWN("485", "ä¸èƒ½åˆ é™¤è‡ªå·±"),
    FAILED_USER_ALREADY_EXIST("486", "è¯¥ç”¨æˆ·å·²å­˜åœ¨"),
    INTERNAL_SERVER_ERROR("500", "æœåŠ¡å™¨å†…éƒ¨é”™è¯¯"),
    NOT_IMPLEMENTED("501", "ä¸šåŠ¡å¼‚å¸¸"),
    CUOWO("502", "æ—¶é—´åç§°æ˜¯å”¯ä¸€çš„");
<<<<<<< HEAD
=======
    OK("200", "´¦Àí³É¹¦"),
    BAD_REQUEST("400", "ÇëÇó²ÎÊýÓÐÎó"),
    UNAUTHORIZED("401", "Î´ÊÚÈ¨"),
    PARAMS_MISS("483", "È±ÉÙ½Ó¿ÚÖÐ±ØÌî²ÎÊý"),
    PARAM_ERROR("484", "²ÎÊý·Ç·¨"),
    FAILED_DEL_OWN("485", "²»ÄÜÉ¾³ý×Ô¼º"),
    FAILED_USER_ALREADY_EXIST("486", "¸ÃÓÃ»§ÒÑ´æÔÚ"),
    INTERNAL_SERVER_ERROR("500", "·þÎñÆ÷ÄÚ²¿´íÎó"),
    NOT_IMPLEMENTED("501", "ÒµÎñÒì³£");
>>>>>>> c4f417e7916eb26ad73ce5ba8718fb68e4b21685
=======
>>>>>>> dev

    private String code;
    private String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
