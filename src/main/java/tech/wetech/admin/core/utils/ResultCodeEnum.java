package tech.wetech.admin.core.utils;

/**
 * @author cjbi
 */
public enum ResultCodeEnum {

<<<<<<< HEAD
    OK("200", "处理成功"),
    BAD_REQUEST("400", "请求参数有误"),
    UNAUTHORIZED("401", "未授权"),
    PARAMS_MISS("483", "缺少接口中必填参数"),
    PARAM_ERROR("484", "参数非法"),
    FAILED_DEL_OWN("485", "不能删除自己"),
    FAILED_USER_ALREADY_EXIST("486", "该用户已存在"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    NOT_IMPLEMENTED("501", "业务异常"),
    FAILED_BASICNAME_ALREADY_EXIST("444", "该档案名称已存在"),
    FAILED_BASICNO_ALREADY_EXIST("445", "该档案编号已存在"),
    FAILED_CLASSIFYING_ALREADY_EXIST("446","是否分级选择“是”后,不能修改为“否”！！");
=======
    OK("200", "澶勭悊鎴愬姛"),
    BAD_REQUEST("400", "璇锋眰鍙傛暟鏈夎"),
    UNAUTHORIZED("401", "鏈巿鏉�"),
    PARAMS_MISS("483", "缂哄皯鎺ュ彛涓繀濉弬鏁�"),
    PARAM_ERROR("484", "鍙傛暟闈炴硶"),
    FAILED_DEL_OWN("485", "涓嶈兘鍒犻櫎鑷繁"),
    FAILED_USER_ALREADY_EXIST("486", "璇ョ敤鎴峰凡瀛樺湪"),
    INTERNAL_SERVER_ERROR("500", "鏈嶅姟鍣ㄥ唴閮ㄩ敊璇�"),
    NOT_IMPLEMENTED("501", "涓氬姟寮傚父"),
    CUOWO("502", "鏃堕棿鍚嶇О鏄敮涓�鐨�");
>>>>>>> 8fb5d7915b12b450a648d8653773f9d4aa5f38fd

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
