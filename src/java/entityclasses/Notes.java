/*
 * Created by Luke Mazzu on 2017.04.18  * 
 * Copyright © 2017 Luke Mazzu. All rights reserved. * 
 */
package entityclasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luke
 */
@Entity
@Table(name = "Notes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notes.findAll", query = "SELECT n FROM Notes n")
    , @NamedQuery(name = "Notes.findById", query = "SELECT n FROM Notes n WHERE n.id = :id")
    , @NamedQuery(name = "Notes.findByTitle", query = "SELECT n FROM Notes n WHERE n.title = :title")
    , @NamedQuery(name = "Notes.findByCreatedTime", query = "SELECT n FROM Notes n WHERE n.createdTime = :createdTime")
    , @NamedQuery(name = "Notes.findByModifiedTime", query = "SELECT n FROM Notes n WHERE n.modifiedTime = :modifiedTime")})
public class Notes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @Column(name = "modified_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;
    @Lob
    @Column(name = "content")
    private String content;
    @OneToMany(mappedBy = "noteId")
    private Collection<UserFile> userFileCollection;
    @OneToMany(mappedBy = "noteId")
    private Collection<Activity> activityCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Notes() {
    }

    public Notes(Integer id) {
        this.id = id;
    }

    public Notes(Integer id, String title, Date createdTime, Date modifiedTime) {
        this.id = id;
        this.title = title;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlTransient
    public Collection<UserFile> getUserFileCollection() {
        return userFileCollection;
    }

    public void setUserFileCollection(Collection<UserFile> userFileCollection) {
        this.userFileCollection = userFileCollection;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notes)) {
            return false;
        }
        Notes other = (Notes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclasses.Notes[ id=" + id + " ]";
    }
    
}
