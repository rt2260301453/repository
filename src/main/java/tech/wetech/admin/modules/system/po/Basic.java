package tech.wetech.admin.modules.system.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Table(name="basic")
public class Basic {
    /**
     * 基本档案编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "基本档案编号不能为空")
    @Pattern(regexp = "^d\\d{5}$",message = "档案编号格式不正确")
    private String basicno;

    /**
     * 基本档案名称
     */
    @NotNull(message = "基本档案名称不能为空")
    private String basicname;

    /**
     * 档案是否分级1为是0为否
     */
    private Integer classifying;

    /**
     * 备注
     */
    @Length(max= 20,message = "备注内容不能超过20字")
    private String remark;

    /**
     * 操作人员
     */
    private String operator;

    /**
     * 操作单位
     */
    @NotNull(message = "操作单位不能为空")
    private String operationunit;

    /**
     * 操作时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss",timezone="GMT+8")
    private Date operationdate;

    /**
     * 获取基本档案编号
     *
     * @return basicno - 基本档案编号
     */
    public String getBasicno() {
        return basicno;
    }

    /**
     * 设置基本档案编号
     *
     * @param basicno 基本档案编号
     */
    public void setBasicno(String basicno) {
        this.basicno = basicno;
    }

    /**
     * 获取基本档案名称
     *
     * @return basicname - 基本档案名称
     */
    public String getBasicname() {
        return basicname;
    }

    /**
     * 设置基本档案名称
     *
     * @param basicname 基本档案名称
     */
    public void setBasicname(String basicname) {
        this.basicname = basicname;
    }

    /**
     * 获取档案是否分级1为是0为否
     *
     * @return classifying - 档案是否分级1为是0为否
     */
    public Integer getClassifying() {
        return classifying;
    }

    /**
     * 设置档案是否分级1为是0为否
     *
     * @param classifying 档案是否分级1为是0为否
     */
    public void setClassifying(Integer classifying) {
        this.classifying = classifying;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取操作人员
     *
     * @return operator - 操作人员
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作人员
     *
     * @param operator 操作人员
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取操作单位
     *
     * @return operationunit - 操作单位
     */
    public String getOperationunit() {
        return operationunit;
    }

    /**
     * 设置操作单位
     *
     * @param operationunit 操作单位
     */
    public void setOperationunit(String operationunit) {
        this.operationunit = operationunit;
    }

    /**
     * 获取操作时间
     *
     * @return operationdate - 操作时间
     */
    public Date getOperationdate() {
        return operationdate;
    }

    /**
     * 设置操作时间
     *
     * @param operationdate 操作时间
     */
    public void setOperationdate(Date operationdate) {
        this.operationdate = operationdate;
    }
}