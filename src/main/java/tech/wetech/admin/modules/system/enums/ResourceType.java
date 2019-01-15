package tech.wetech.admin.modules.system.enums;

public enum ResourceType {
    MENU("²Ëµ¥"), BUTTON("°´Å¥");

    private final String info;

    private ResourceType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}