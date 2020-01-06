package ebmsapp.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Process generated by hbm2java
 */
@Entity
@Table(name="process"
    ,catalog="ebms_db"
)
public class Process  implements java.io.Serializable {


     private Integer idprocess;
     private String value;

    public Process() {
    }

    public Process(String value) {
       this.value = value;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idprocess", unique=true, nullable=false)
    public Integer getIdprocess() {
        return this.idprocess;
    }
    
    public void setIdprocess(Integer idprocess) {
        this.idprocess = idprocess;
    }

    
    @Column(name="value", length=45)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }




}

