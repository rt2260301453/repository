package tech.wetech.admin.core.utils;

/**
 * @author cjbi
 */
public enum ResultCodeEnum {
    OK("200", "����ɹ�"),
    BAD_REQUEST("400", "�����������"),
    UNAUTHORIZED("401", "δ��Ȩ"),
    PARAMS_MISS("483", "ȱ�ٽӿ��б������"),
    PARAM_ERROR("484", "�����Ƿ�"),
    FAILED_DEL_OWN("485", "����ɾ���Լ�"),
    FAILED_USER_ALREADY_EXIST("486", "���û��Ѵ���"),
    FAILED_USER_CODE_EXIST("487", "�ñ���Ѵ���"),
    INTERNAL_SERVER_ERROR("500", "�������ڲ�����"),
    NOT_IMPLEMENTED("501", "ҵ���쳣"),
    FAILED_BASICNAME_ALREADY_EXIST("444", "�õ��������Ѵ���"),
    FAILED_BASICNO_ALREADY_EXIST("445", "�õ�������Ѵ���"),
    FAILED_CLASSIFYING_ALREADY_EXIST("446","�Ƿ�ּ�ѡ���ǡ���,�����޸�Ϊ���񡱣���"),
    CUOWO("502", "ʱ��������Ψһ��");

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
