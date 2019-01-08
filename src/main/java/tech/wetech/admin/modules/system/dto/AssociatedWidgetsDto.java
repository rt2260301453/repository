package tech.wetech.admin.modules.system.dto;


import tech.wetech.admin.modules.system.po.AssociatedWidgets;

public class AssociatedWidgetsDto {
    private Integer id;
    private String fixedareano;
    private String fetchpeopleno;
    private String fetchpeoplename;
    private String collectionstandard;
    private String collectiontime;
    private String institute;
    private String type;

    public AssociatedWidgetsDto(AssociatedWidgets associatedWidgets) {
        this.id = associatedWidgets.getId();
        this.fixedareano = associatedWidgets.getFixedareano();
        this.fetchpeopleno = fetchpeopleno;
        this.fetchpeoplename = fetchpeoplename;
        this.collectionstandard = collectionstandard;
        this.collectiontime = collectiontime;
        this.institute = institute;
        this.type = type;
    }
}