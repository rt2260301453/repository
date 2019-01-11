package tech.wetech.admin.core.utils;

/**
 * @author cjbi
 */
public enum ResultCodeEnum {

<<<<<<< HEAD
    OK("200", "����ɹ�"),
    BAD_REQUEST("400", "�����������"),
    UNAUTHORIZED("401", "δ��Ȩ"),
    PARAMS_MISS("483", "ȱ�ٽӿ��б������"),
    PARAM_ERROR("484", "�����Ƿ�"),
    FAILED_DEL_OWN("485", "����ɾ���Լ�"),
    FAILED_USER_ALREADY_EXIST("486", "���û��Ѵ���"),
    INTERNAL_SERVER_ERROR("500", "�������ڲ�����"),
    NOT_IMPLEMENTED("501", "ҵ���쳣"),
    FAILED_BASICNAME_ALREADY_EXIST("444", "�õ��������Ѵ���"),
    FAILED_BASICNO_ALREADY_EXIST("445", "�õ�������Ѵ���"),
    FAILED_CLASSIFYING_ALREADY_EXIST("446","�Ƿ�ּ�ѡ���ǡ���,�����޸�Ϊ���񡱣���");
=======
    OK("200", "处理成功"),
    BAD_REQUEST("400", "请求参数有误"),
    UNAUTHORIZED("401", "未授权"),
    PARAMS_MISS("483", "缺少接口中必填参数"),
    PARAM_ERROR("484", "参数非法"),
    FAILED_DEL_OWN("485", "不能删除自己"),
    FAILED_USER_ALREADY_EXIST("486", "该用户已存在"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    NOT_IMPLEMENTED("501", "业务异常"),
    CUOWO("502", "时间名称是唯一的");
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
