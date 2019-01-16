package tech.wetech.admin.modules.system.enums;

public enum ClassifyingType {
    wq("否"), qw("是");

    private final String info;

    private ClassifyingType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
