package tech.wetech.admin.core.utils;

/**
 * @author cjbi
 */
public enum ResultCodeEnum {

<<<<<<< HEAD
<<<<<<< HEAD
    OK("200", "å¤„ç†æˆåŠŸ"),
    BAD_REQUEST("400", "è¯·æ±‚å‚æ•°æœ‰è¯¯"),
    UNAUTHORIZED("401", "æœªæˆæƒ"),
    PARAMS_MISS("483", "ç¼ºå°‘æ¥å£ä¸­å¿…å¡«å‚æ•°"),
    PARAM_ERROR("484", "å‚æ•°éæ³•"),
    FAILED_DEL_OWN("485", "ä¸èƒ½åˆ é™¤è‡ªå·±"),
    FAILED_USER_ALREADY_EXIST("486", "è¯¥ç”¨æˆ·å·²å­˜åœ¨"),
    INTERNAL_SERVER_ERROR("500", "æœåŠ¡å™¨å†…éƒ¨é”™è¯¯"),
    NOT_IMPLEMENTED("501", "ä¸šåŠ¡å¼‚å¸¸"),
    CUOWO("502", "æ—¶é—´åç§°æ˜¯å”¯ä¸€çš„");
<<<<<<< HEAD
=======
=======

>>>>>>> cc7c401a40aa9bdc58c17641f0d8b4db5366311b
    OK("200", "´¦Àí³É¹¦"),
    BAD_REQUEST("400", "ÇëÇó²ÎÊıÓĞÎó"),
    UNAUTHORIZED("401", "Î´ÊÚÈ¨"),
    PARAMS_MISS("483", "È±ÉÙ½Ó¿ÚÖĞ±ØÌî²ÎÊı"),
    PARAM_ERROR("484", "²ÎÊı·Ç·¨"),
    FAILED_DEL_OWN("485", "²»ÄÜÉ¾³ı×Ô¼º"),
    FAILED_USER_ALREADY_EXIST("486", "¸ÃÓÃ»§ÒÑ´æÔÚ"),
    INTERNAL_SERVER_ERROR("500", "·şÎñÆ÷ÄÚ²¿´íÎó"),
<<<<<<< HEAD
    NOT_IMPLEMENTED("501", "ÒµÎñÒì³£");
>>>>>>> c4f417e7916eb26ad73ce5ba8718fb68e4b21685
=======
>>>>>>> dev
=======
    NOT_IMPLEMENTED("501", "ÒµÎñÒì³£"),
    FAILED_BASICNAME_ALREADY_EXIST("444", "¸Ãµµ°¸Ãû³ÆÒÑ´æÔÚ"),
    FAILED_BASICNO_ALREADY_EXIST("445", "¸Ãµµ°¸±àºÅÒÑ´æÔÚ"),
    FAILED_CLASSIFYING_ALREADY_EXIST("446","ÊÇ·ñ·Ö¼¶Ñ¡Ôñ¡°ÊÇ¡±ºó,²»ÄÜĞŞ¸ÄÎª¡°·ñ¡±£¡£¡"),
    CUOWO("502", "Ê±¼äÃû³ÆÊÇÎ¨Ò»µÄ");
>>>>>>> cc7c401a40aa9bdc58c17641f0d8b4db5366311b

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
