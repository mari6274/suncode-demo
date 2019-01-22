package pl.edu.amu.wmi.students.mario.suncodedemo.entities;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AuditTable("APPLICATION_STATUS_HISTORY")
@AuditOverride
@Table(name = "tabela_testowa")
public class ExampleEntity {

    @Id
    private Long id;

    @Column(name = "kolumna1", length = 256)
    private String column1;

    @Column(name = "kolumna2", length = 256)
    private String column2;

    @Column(name = "kolumna3", length = 256)
    private String column3;

    @Audited
    @Column(name = "kolumna4")
    private Long column4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public Long getColumn4() {
        return column4;
    }

    public void setColumn4(Long column4) {
        this.column4 = column4;
    }
}
