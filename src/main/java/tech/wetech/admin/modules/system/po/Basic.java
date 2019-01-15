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
     * �����������
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "����������Ų���Ϊ��")
    @Pattern(regexp = "^d\\d{5}$",message = "������Ÿ�ʽ����ȷ")
    private String basicno;

    /**
     * ������������
     */
    @NotNull(message = "�����������Ʋ���Ϊ��")
    private String basicname;

    /**
     * �����Ƿ�ּ�1Ϊ��0Ϊ��
     */
    private Integer classifying;

    /**
     * ��ע
     */
    @Length(max= 20,message = "��ע���ݲ��ܳ���20��")
    private String remark;

    /**
     * ������Ա
     */
    private String operator;

    /**
     * ������λ
     */
    @NotNull(message = "������λ����Ϊ��")
    private String operationunit;

    /**
     * ����ʱ��
     */
    @DateTimeFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss",timezone="GMT+8")
    private Date operationdate;

    /**
     * ��ȡ�����������
     *
     * @return basicno - �����������
     */
    public String getBasicno() {
        return basicno;
    }

    /**
     * ���û����������
     *
     * @param basicno �����������
     */
    public void setBasicno(String basicno) {
        this.basicno = basicno;
    }

    /**
     * ��ȡ������������
     *
     * @return basicname - ������������
     */
    public String getBasicname() {
        return basicname;
    }

    /**
     * ���û�����������
     *
     * @param basicname ������������
     */
    public void setBasicname(String basicname) {
        this.basicname = basicname;
    }

    /**
     * ��ȡ�����Ƿ�ּ�1Ϊ��0Ϊ��
     *
     * @return classifying - �����Ƿ�ּ�1Ϊ��0Ϊ��
     */
    public Integer getClassifying() {
        return classifying;
    }

    /**
     * ���õ����Ƿ�ּ�1Ϊ��0Ϊ��
     *
     * @param classifying �����Ƿ�ּ�1Ϊ��0Ϊ��
     */
    public void setClassifying(Integer classifying) {
        this.classifying = classifying;
    }

    /**
     * ��ȡ��ע
     *
     * @return remark - ��ע
     */
    public String getRemark() {
        return remark;
    }

    /**
     * ���ñ�ע
     *
     * @param remark ��ע
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * ��ȡ������Ա
     *
     * @return operator - ������Ա
     */
    public String getOperator() {
        return operator;
    }

    /**
     * ���ò�����Ա
     *
     * @param operator ������Ա
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * ��ȡ������λ
     *
     * @return operationunit - ������λ
     */
    public String getOperationunit() {
        return operationunit;
    }

    /**
     * ���ò�����λ
     *
     * @param operationunit ������λ
     */
    public void setOperationunit(String operationunit) {
        this.operationunit = operationunit;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return operationdate - ����ʱ��
     */
    public Date getOperationdate() {
        return operationdate;
    }

    /**
     * ���ò���ʱ��
     *
     * @param operationdate ����ʱ��
     */
    public void setOperationdate(Date operationdate) {
        this.operationdate = operationdate;
    }
}