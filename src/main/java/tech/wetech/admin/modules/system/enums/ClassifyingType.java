package tech.wetech.admin.modules.system.enums;

public enum ClassifyingType {
    wq("·ñ"), qw("ÊÇ");

    private final String info;

    private ClassifyingType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
