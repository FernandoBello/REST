/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestfulService;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ArqSoft
 */
@Entity
@Table(name = "resultexam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultexam.findAll", query = "SELECT r FROM Resultexam r"),
    @NamedQuery(name = "Resultexam.findByResultExamId", query = "SELECT r FROM Resultexam r WHERE r.resultExamId = :resultExamId"),
    @NamedQuery(name = "Resultexam.findByApproved", query = "SELECT r FROM Resultexam r WHERE r.approved = :approved"),
    @NamedQuery(name = "Resultexam.findByStatus", query = "SELECT r FROM Resultexam r WHERE r.status = :status")})
public class Resultexam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resultExamId")
    private Integer resultExamId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approved")
    private int approved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "idUser", referencedColumnName = "idAuthentication")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "idExam", referencedColumnName = "examId")
    @ManyToOne(optional = false)
    private Exam idExam;

    public Resultexam() {
    }

    public Resultexam(Integer resultExamId) {
        this.resultExamId = resultExamId;
    }

    public Resultexam(Integer resultExamId, int approved, int status) {
        this.resultExamId = resultExamId;
        this.approved = approved;
        this.status = status;
    }

    public Integer getResultExamId() {
        return resultExamId;
    }

    public void setResultExamId(Integer resultExamId) {
        this.resultExamId = resultExamId;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Exam getIdExam() {
        return idExam;
    }

    public void setIdExam(Exam idExam) {
        this.idExam = idExam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultExamId != null ? resultExamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultexam)) {
            return false;
        }
        Resultexam other = (Resultexam) object;
        if ((this.resultExamId == null && other.resultExamId != null) || (this.resultExamId != null && !this.resultExamId.equals(other.resultExamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RestfulService.Resultexam[ resultExamId=" + resultExamId + " ]";
    }
    
}
