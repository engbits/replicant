package org.engbits.replicant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Model of a Job in the Replicant system
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Entity
@Table(name = "jobs")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "job_id", nullable = false)
    private Long jobId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "hiring_manager")
    private String hiringManager;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "jobId")
    private List<JobCandidate> candidates = new LinkedList<>();

    @JsonIgnore
    @Column(name = "create_date", nullable = false, updatable = false)
    private Date createDate;

    @JsonIgnore
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public void setHiringManager(String hiringManager) {
        this.hiringManager = hiringManager;
    }

    public List<JobCandidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(final List<JobCandidate> candidates) {
        this.candidates = candidates;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
