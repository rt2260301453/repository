package tech.wetech.admin.modules.system.po;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cjbi
 */
@Data
@Table(name = "sys_user")
public class User {

    /**
     * ���
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * ������˾
     */
    @NotNull(message = "������֯����Ϊ��")
    private Long organizationId;
    /**
     * �û���
     */
    @NotBlank(message = "�û�������Ϊ��")
    @Length(min= 3,message = "�û������ܵ���3λ")
    private String username;
    /**
     * ����
     */
    @NotBlank(message = "���벻��Ϊ��")
    @Length(min= 6,message = "�û������ܵ���6λ")
    private String password;
    /**
     * �����������
     */
    private String salt;
    /**
     * ӵ�еĽ�ɫ�б�
     */
    private String roleIds;

    @Transient
    private List<Long> roleIdList;

    private String groupIds;

    @Transient
    private List<Long> groupIdList;

    private Boolean locked = Boolean.FALSE;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        String[] roleIdStrs = roleIds.split(",");
        for (String roleId : roleIdStrs) {
            if (StringUtils.isEmpty(roleId)) {
                continue;
            }
            getRoleIdList().add(Long.valueOf(roleId));
        }
        this.roleIds = roleIds;
    }

    public List<Long> getRoleIdList() {
        if (roleIdList == null) {
            roleIdList = new ArrayList<>();
        }
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        StringBuilder s = new StringBuilder();
        for (Long roleId : roleIdList) {
            s.append(roleId);
            s.append(",");
        }
        if (s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }
        this.roleIds = s.toString();
        this.roleIdList = roleIdList;
    }

    public String getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String groupIds) {
        String[] groupIdStrs = groupIds.split(",");
        for (String groupId : groupIdStrs) {
            if (StringUtils.isEmpty(groupId)) {
                continue;
            }
            getGroupIdList().add(Long.valueOf(groupId));
        }
        this.groupIds = groupIds;
    }

    public List<Long> getGroupIdList() {
        if (groupIdList == null) {
            groupIdList = new ArrayList<>();
        }
        return groupIdList;
    }

    public void setGroupIdList(List<Long> groupIdList) {
        StringBuilder s = new StringBuilder();
        for (Long groupId : groupIdList) {
            s.append(groupId);
            s.append(",");
        }
        if (s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }
        this.groupIds = s.toString();
        this.groupIdList = groupIdList;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

}
