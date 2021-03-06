package ebmsapp.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="ebms_db"
)
public class User  implements java.io.Serializable {


     private Integer iduser;
     private String fullname;
     private String matricule;
     private String username;
     private String password;
     private String type;
     private String picture;

    public User() {
    }

	
    public User(String fullname, String username, String password, String type) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.type = type;
    }
    public User(String fullname, String matricule, String username, String password, String type, String picture) {
       this.fullname = fullname;
       this.matricule = matricule;
       this.username = username;
       this.password = password;
       this.type = type;
       this.picture = picture;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="iduser", unique=true, nullable=false)
    public Integer getIduser() {
        return this.iduser;
    }
    
    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    
    @Column(name="fullname", nullable=false, length=45)
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    
    @Column(name="matricule", length=45)
    public String getMatricule() {
        return this.matricule;
    }
    
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    
    @Column(name="username", nullable=false, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="type", nullable=false, length=45)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    
    @Column(name="picture", length=45)
    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }




}


