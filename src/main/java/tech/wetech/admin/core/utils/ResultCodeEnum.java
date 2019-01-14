package tech.wetech.admin.core.utils;

/**
 * @author cjbi
 */
public enum ResultCodeEnum {
<<<<<<< HEAD


    OK("200", "´¦Àí³É¹¦"),
    BAD_REQUEST("400", "ÇëÇó²ÎÊýÓÐÎó"),
    UNAUTHORIZED("401", "Î´ÊÚÈ¨"),
    PARAMS_MISS("483", "È±ÉÙ½Ó¿ÚÖÐ±ØÌî²ÎÊý"),
    PARAM_ERROR("484", "²ÎÊý·Ç·¨"),
    FAILED_DEL_OWN("485", "²»ÄÜÉ¾³ý×Ô¼º"),
    FAILED_USER_ALREADY_EXIST("486", "¸ÃÓÃ»§ÒÑ´æÔÚ"),
    INTERNAL_SERVER_ERROR("500", "·þÎñÆ÷ÄÚ²¿´íÎó"),
    NOT_IMPLEMENTED("501", "ÒµÎñÒì³£"),
    FAILED_BASICNAME_ALREADY_EXIST("444", "¸Ãµµ°¸Ãû³ÆÒÑ´æÔÚ"),
    FAILED_BASICNO_ALREADY_EXIST("445", "¸Ãµµ°¸±àºÅÒÑ´æÔÚ"),
    FAILED_CLASSIFYING_ALREADY_EXIST("446","ÊÇ·ñ·Ö¼¶Ñ¡Ôñ¡°ÊÇ¡±ºó,²»ÄÜÐÞ¸ÄÎª¡°·ñ¡±£¡£¡"),
    CUOWO("502", "Ê±¼äÃû³ÆÊÇÎ¨Ò»µÄ");

=======
    OK("200", "å¤„ç†æˆåŠŸ"),
    BAD_REQUEST("400", "è¯·æ±‚å‚æ•°æœ‰è¯¯"),
    UNAUTHORIZED("401", "æœªæŽˆæƒ"),
    FAILED_BASICNAME_ALREADY_EXIST("444", "è¯¥æ¡£æ¡ˆåç§°å·²å­˜åœ¨"),
    FAILED_BASICNO_ALREADY_EXIST("445", "è¯¥æ¡£æ¡ˆç¼–å·å·²å­˜åœ¨"),
    FAILED_CLASSIFYING_ALREADY_EXIST("446","æ˜¯å¦åˆ†çº§é€‰æ‹©â€œæ˜¯â€åŽ,ä¸èƒ½ä¿®æ”¹ä¸ºâ€œå¦â€ï¼ï¼"),
    PARAMS_MISS("483", "ç¼ºå°‘æŽ¥å£ä¸­å¿…å¡«å‚æ•°"),
    PARAM_ERROR("484", "å‚æ•°éžæ³•"),
    FAILED_DEL_OWN("485", "ä¸èƒ½åˆ é™¤è‡ªå·±"),
    FAILED_USER_ALREADY_EXIST("486", "è¯¥ç”¨æˆ·å·²å­˜åœ¨"),
    INTERNAL_SERVER_ERROR("500", "æœåŠ¡å™¨å†…éƒ¨é”™è¯¯"),
    NOT_IMPLEMENTED("501", "ä¸šåŠ¡å¼‚å¸¸"),
    CUOWO("502", "æ—¶é—´åç§°æ˜¯å”¯ä¸€çš„");
>>>>>>> 1a948da644e1dddeeeb6cb6fd49c772a2ca26bc1

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
