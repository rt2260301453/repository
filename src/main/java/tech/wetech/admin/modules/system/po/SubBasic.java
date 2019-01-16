package tech.wetech.admin.modules.system.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Table(name="subbasic")
public class SubBasic {
    /**
     * 子级档案编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "档案编号不能为空")
    @Pattern(regexp = "^zd\\d{5}$",message = "档案编号格式不正确")
    private String subbasicno;

    /**
     * 子级档案名称
     */
    @NotNull(message = "档案名称不能为空")
    private String subbasicname;

    /**
     * 上级编码
     */
    @Pattern(regexp = "^d\\d{5}$",message = "上级编号格式不正确")
    private String mainbasicno;

    /**
     * 助记码
     */
    private String mnemoniccode;

    /**
     * 封存标记
     */
    private Integer archivemark;

    /**
     * 子级备注
     */
    @Length(max= 20,message = "备注内容不能超过20字")
    private String subremark;

    /**
     * 子级操作人员
     */
    private String suboperator;

    /**
     * 子级操作单位
     */
    @NotNull(message = "操作人员单位不能为空")
    private String suboperationunit;

    /**
     * 子级操作时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss",timezone="GMT+8")
    private Date suboperationdate;

    /**
     * 获取子级档案编号
     *
     * @return subbasicno - 子级档案编号
     */
    public String getSubbasicno() {
        return subbasicno;
    }

    /**
     * 设置子级档案编号
     *
     * @param subbasicno 子级档案编号
     */
    public void setSubbasicno(String subbasicno) {
        this.subbasicno = subbasicno;
    }

    /**
     * 获取子级档案名称
     *
     * @return subbasicname - 子级档案名称
     */
    public String getSubbasicname() {
        return subbasicname;
    }

    /**
     * 设置子级档案名称
     *
     * @param subbasicname 子级档案名称
     */
    public void setSubbasicname(String subbasicname) {
        this.subbasicname = subbasicname;
    }

    /**
     * 获取上级编码
     *
     * @return mainbasicno - 上级编码
     */
    public String getMainbasicno() {
        return mainbasicno;
    }

    /**
     * 设置上级编码
     *
     * @param mainbasicno 上级编码
     */
    public void setMainbasicno(String mainbasicno) {
        this.mainbasicno = mainbasicno;
    }

    /**
     * 获取助记码
     *
     * @return mnemoniccode - 助记码
     */
    public String getMnemoniccode() {
        return mnemoniccode;
    }

    /**
     * 设置助记码
     *
     * @param mnemoniccode 助记码
     */
    public void setMnemoniccode(String mnemoniccode) {
        this.mnemoniccode = mnemoniccode;
    }

    /**
     * 获取封存标记
     *
     * @return archivemark - 封存标记
     */
    public Integer getArchivemark() {
        return archivemark;
    }

    /**
     * 设置封存标记
     *
     * @param archivemark 封存标记
     */
    public void setArchivemark(Integer archivemark) {
        this.archivemark = archivemark;
    }

    /**
     * 获取子级备注
     *
     * @return subremark - 子级备注
     */
    public String getSubremark() {
        return subremark;
    }

    /**
     * 设置子级备注
     *
     * @param subremark 子级备注
     */
    public void setSubremark(String subremark) {
        this.subremark = subremark;
    }

    /**
     * 获取子级操作人员
     *
     * @return suboperator - 子级操作人员
     */
    public String getSuboperator() {
        return suboperator;
    }

    /**
     * 设置子级操作人员
     *
     * @param suboperator 子级操作人员
     */
    public void setSuboperator(String suboperator) {
        this.suboperator = suboperator;
    }

    /**
     * 获取子级操作单位
     *
     * @return suboperationunit - 子级操作单位
     */
    public String getSuboperationunit() {
        return suboperationunit;
    }

    /**
     * 设置子级操作单位
     *
     * @param suboperationunit 子级操作单位
     */
    public void setSuboperationunit(String suboperationunit) {
        this.suboperationunit = suboperationunit;
    }

    /**
     * 获取子级操作时间
     *
     * @return suboperationdate - 子级操作时间
     */
    public Date getSuboperationdate() {
        return suboperationdate;
    }

    /**
     * 设置子级操作时间
     *
     * @param suboperationdate 子级操作时间
     */
    public void setSuboperationdate(Date suboperationdate) {
        this.suboperationdate = suboperationdate;
    }
}