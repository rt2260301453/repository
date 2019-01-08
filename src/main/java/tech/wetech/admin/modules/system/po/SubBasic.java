package tech.wetech.admin.modules.system.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Table(name="subbasic")
public class SubBasic {
    /**
     * �Ӽ��������
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String subbasicno;

    /**
     * �Ӽ���������
     */
    private String subbasicname;

    /**
     * �ϼ�����
     */
    private String mainbasicno;

    /**
     * ������
     */
    private String mnemoniccode;

    /**
     * �����
     */
    private Integer archivemark;

    /**
     * �Ӽ���ע
     */
    private String subremark;

    /**
     * �Ӽ�������Ա
     */
    private String suboperator;

    /**
     * �Ӽ�������λ
     */
    private String suboperationunit;

    /**
     * �Ӽ�����ʱ��
     */
    @DateTimeFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss",timezone="GMT+8")
    private Date suboperationdate;

    /**
     * ��ȡ�Ӽ��������
     *
     * @return subbasicno - �Ӽ��������
     */
    public String getSubbasicno() {
        return subbasicno;
    }

    /**
     * �����Ӽ��������
     *
     * @param subbasicno �Ӽ��������
     */
    public void setSubbasicno(String subbasicno) {
        this.subbasicno = subbasicno;
    }

    /**
     * ��ȡ�Ӽ���������
     *
     * @return subbasicname - �Ӽ���������
     */
    public String getSubbasicname() {
        return subbasicname;
    }

    /**
     * �����Ӽ���������
     *
     * @param subbasicname �Ӽ���������
     */
    public void setSubbasicname(String subbasicname) {
        this.subbasicname = subbasicname;
    }

    /**
     * ��ȡ�ϼ�����
     *
     * @return mainbasicno - �ϼ�����
     */
    public String getMainbasicno() {
        return mainbasicno;
    }

    /**
     * �����ϼ�����
     *
     * @param mainbasicno �ϼ�����
     */
    public void setMainbasicno(String mainbasicno) {
        this.mainbasicno = mainbasicno;
    }

    /**
     * ��ȡ������
     *
     * @return mnemoniccode - ������
     */
    public String getMnemoniccode() {
        return mnemoniccode;
    }

    /**
     * ����������
     *
     * @param mnemoniccode ������
     */
    public void setMnemoniccode(String mnemoniccode) {
        this.mnemoniccode = mnemoniccode;
    }

    /**
     * ��ȡ�����
     *
     * @return archivemark - �����
     */
    public Integer getArchivemark() {
        return archivemark;
    }

    /**
     * ���÷����
     *
     * @param archivemark �����
     */
    public void setArchivemark(Integer archivemark) {
        this.archivemark = archivemark;
    }

    /**
     * ��ȡ�Ӽ���ע
     *
     * @return subremark - �Ӽ���ע
     */
    public String getSubremark() {
        return subremark;
    }

    /**
     * �����Ӽ���ע
     *
     * @param subremark �Ӽ���ע
     */
    public void setSubremark(String subremark) {
        this.subremark = subremark;
    }

    /**
     * ��ȡ�Ӽ�������Ա
     *
     * @return suboperator - �Ӽ�������Ա
     */
    public String getSuboperator() {
        return suboperator;
    }

    /**
     * �����Ӽ�������Ա
     *
     * @param suboperator �Ӽ�������Ա
     */
    public void setSuboperator(String suboperator) {
        this.suboperator = suboperator;
    }

    /**
     * ��ȡ�Ӽ�������λ
     *
     * @return suboperationunit - �Ӽ�������λ
     */
    public String getSuboperationunit() {
        return suboperationunit;
    }

    /**
     * �����Ӽ�������λ
     *
     * @param suboperationunit �Ӽ�������λ
     */
    public void setSuboperationunit(String suboperationunit) {
        this.suboperationunit = suboperationunit;
    }

    /**
     * ��ȡ�Ӽ�����ʱ��
     *
     * @return suboperationdate - �Ӽ�����ʱ��
     */
    public Date getSuboperationdate() {
        return suboperationdate;
    }

    /**
     * �����Ӽ�����ʱ��
     *
     * @param suboperationdate �Ӽ�����ʱ��
     */
    public void setSuboperationdate(Date suboperationdate) {
        this.suboperationdate = suboperationdate;
    }
}