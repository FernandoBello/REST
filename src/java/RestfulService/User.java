/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestfulService;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ArqSoft
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender"),
    @NamedQuery(name = "User.findByIdAuthentication", query = "SELECT u FROM User u WHERE u.idAuthentication = :idAuthentication")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private int gender;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idAuthentication")
    private String idAuthentication;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Resultexam> resultexamCollection;

    public User() {
    }

    public User(String idAuthentication) {
        this.idAuthentication = idAuthentication;
    }

    public User(String idAuthentication, String name, String email, int gender) {
        this.idAuthentication = idAuthentication;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdAuthentication() {
        return idAuthentication;
    }

    public void setIdAuthentication(String idAuthentication) {
        this.idAuthentication = idAuthentication;
    }

    @XmlTransient
    public Collection<Resultexam> getResultexamCollection() {
        return resultexamCollection;
    }

    public void setResultexamCollection(Collection<Resultexam> resultexamCollection) {
        this.resultexamCollection = resultexamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuthentication != null ? idAuthentication.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idAuthentication == null && other.idAuthentication != null) || (this.idAuthentication != null && !this.idAuthentication.equals(other.idAuthentication))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RestfulService.User[ idAuthentication=" + idAuthentication + " ]";
    }
    
}
