package ebmsapp.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cities generated by hbm2java
 */
@Entity
@Table(name="cities"
    ,catalog="ebms_db"
)
public class Cities  implements java.io.Serializable {


     private Integer idcitie;
     private String name;
     private Set clients = new HashSet(0);

    public Cities() {
    }

    public Cities(String name, Set clients) {
       this.name = name;
       this.clients = clients;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idcitie", unique=true, nullable=false)
    public Integer getIdcitie() {
        return this.idcitie;
    }
    
    public void setIdcitie(Integer idcitie) {
        this.idcitie = idcitie;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cities")
    public Set getClients() {
        return this.clients;
    }
    
    public void setClients(Set clients) {
        this.clients = clients;
    }




}


