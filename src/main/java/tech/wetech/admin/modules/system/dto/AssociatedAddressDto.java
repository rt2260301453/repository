package tech.wetech.admin.modules.system.dto;

import lombok.Data;
import tech.wetech.admin.modules.system.po.AssociatedAddress;
@Data
public class AssociatedAddressDto {
    private Integer id;
    private String fixedareano;
    private String cityname;
    private String customeraddress;
    private String partitionno;

    public AssociatedAddressDto(AssociatedAddress associatedAddress) {
        this.id = associatedAddress.getId();
        this.fixedareano = associatedAddress.getFixedareano();
        this.cityname = associatedAddress.getCityname();
        this.customeraddress = associatedAddress.getCustomeraddress();
        this.partitionno = associatedAddress.getPartitionno();
    }
}