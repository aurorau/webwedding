package com.aurora.model;

import java.io.Serializable;
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
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="company_comments")
public class CompanyComments implements Serializable {
	
	private Long CCID;
	private String commentDescription;
	private String commentedUser;
	private String commentedUserDistrict;
	private String commentedUserEmail;
	private CompanyDetails supplierCompanyDetails;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CCID")
	public Long getCCID() {
		return CCID;
	}
	public void setCCID(Long cCID) {
		CCID = cCID;
	}
	
	@Column(name="comment_description", nullable=true, length=500)
	public String getCommentDescription() {
		return commentDescription;
	}
	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}
	
	@Column(name="commented_user", nullable=true, length=100)
	public String getCommentedUser() {
		return commentedUser;
	}
	public void setCommentedUser(String commentedUser) {
		this.commentedUser = commentedUser;
	}
	
	@Column(name="commented_user_district", nullable=true, length=100)
	public String getCommentedUserDistrict() {
		return commentedUserDistrict;
	}
	public void setCommentedUserDistrict(String commentedUserDistrict) {
		this.commentedUserDistrict = commentedUserDistrict;
	}
	
	@Column(name="commented_user_email", nullable=true, length=100)
	public String getCommentedUserEmail() {
		return commentedUserEmail;
	}
	public void setCommentedUserEmail(String commentedUserEmail) {
		this.commentedUserEmail = commentedUserEmail;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FSCDID", nullable=false)
	@JsonIgnore
	public CompanyDetails getSupplierCompanyDetails() {
		return supplierCompanyDetails;
	}
	public void setSupplierCompanyDetails(CompanyDetails supplierCompanyDetails) {
		this.supplierCompanyDetails = supplierCompanyDetails;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CCID == null) ? 0 : CCID.hashCode());
		result = prime * result + ((commentDescription == null) ? 0 : commentDescription.hashCode());
		result = prime * result + ((commentedUser == null) ? 0 : commentedUser.hashCode());
		result = prime * result + ((commentedUserDistrict == null) ? 0 : commentedUserDistrict.hashCode());
		result = prime * result + ((commentedUserEmail == null) ? 0 : commentedUserEmail.hashCode());
		result = prime * result + ((supplierCompanyDetails == null) ? 0 : supplierCompanyDetails.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyComments other = (CompanyComments) obj;
		if (CCID == null) {
			if (other.CCID != null)
				return false;
		} else if (!CCID.equals(other.CCID))
			return false;
		if (commentDescription == null) {
			if (other.commentDescription != null)
				return false;
		} else if (!commentDescription.equals(other.commentDescription))
			return false;
		if (commentedUser == null) {
			if (other.commentedUser != null)
				return false;
		} else if (!commentedUser.equals(other.commentedUser))
			return false;
		if (commentedUserDistrict == null) {
			if (other.commentedUserDistrict != null)
				return false;
		} else if (!commentedUserDistrict.equals(other.commentedUserDistrict))
			return false;
		if (commentedUserEmail == null) {
			if (other.commentedUserEmail != null)
				return false;
		} else if (!commentedUserEmail.equals(other.commentedUserEmail))
			return false;
		if (supplierCompanyDetails == null) {
			if (other.supplierCompanyDetails != null)
				return false;
		} else if (!supplierCompanyDetails.equals(other.supplierCompanyDetails))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CompanyComments [CCID=" + CCID + ", commentDescription=" + commentDescription + ", commentedUser="
				+ commentedUser + ", commentedUserDistrict=" + commentedUserDistrict + ", commentedUserEmail="
				+ commentedUserEmail + ", supplierCompanyDetails=" + supplierCompanyDetails + "]";
	}

}
