package tech.wetech.admin.modules.system.po;

import org.apache.ibatis.type.JdbcType;
import tech.wetech.admin.modules.system.enums.GroupType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author cjbi
 */
@Table(name = "sys_group")
public class Group {

    /**
     * ���
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * ������
     */
    @NotBlank(message = "�����Ʋ���Ϊ��")
    private String name;

    /**
     * ������
     */
    @NotNull(message = "�����Ͳ���Ϊ��")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private GroupType type;

    /**
     * ����
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupType getType() {
        return type;
    }

    public void setType(GroupType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
