package tech.wetech.admin.modules.system.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Namefromto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String namefrom;

    private String nameto;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return namefrom
     */
    public String getNamefrom() {
        return namefrom;
    }

    /**
     * @param namefrom
     */
    public void setNamefrom(String namefrom) {
        this.namefrom = namefrom;
    }

    /**
     * @return nameto
     */
    public String getNameto() {
        return nameto;
    }

    /**
     * @param nameto
     */
    public void setNameto(String nameto) {
        this.nameto = nameto;
    }

    @Override
    public String toString() {
        return "Namefromto{" +
                "id=" + id +
                ", namefrom='" + namefrom + '\'' +
                ", nameto='" + nameto + '\'' +
                '}';
    }
}