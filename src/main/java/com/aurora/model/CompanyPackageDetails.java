package com.aurora.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="company_news")
public class CompanyNews implements Serializable {
	
	private Long CNID;
	private String description;
	private String imageUrl;
	private CompanyDetails companyDetails;
	private Date newsRegisteredDate;
	private Date newsActiveDate;
	private Long newsActivePeriod;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CNID")
	public Long getCNID() {
		return CNID;
	}
	public void setCNID(Long cNID) {
		CNID = cNID;
	}
	
	@Column(name="news_description", nullable=true, length=500)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="news_image_url", nullable=true, length=200)
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FCDID", nullable=false)
	@JsonIgnore
	public CompanyDetails getCompanyDetails() {
		return companyDetails;
	}
	public void setCompanyDetails(CompanyDetails companyDetails) {
		this.companyDetails = companyDetails;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="news_active_date", nullable=true, length=20)
	public Date getNewsActiveDate() {
		return newsActiveDate;
	}
	public void setNewsActiveDate(Date newsActiveDate) {
		this.newsActiveDate = newsActiveDate;
	}
	
	@Column(name="news_active_period", nullable=true, length=20)
	public Long getNewsActivePeriod() {
		return newsActivePeriod;
	}
	public void setNewsActivePeriod(Long newsActivePeriod) {
		this.newsActivePeriod = newsActivePeriod;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="news_registered_date", nullable=true, length=20)
	public Date getNewsRegisteredDate() {
		return newsRegisteredDate;
	}
	public void setNewsRegisteredDate(Date newsRegisteredDate) {
		this.newsRegisteredDate = newsRegisteredDate;
	}
}
