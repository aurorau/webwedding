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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="article_details")
public class ArticleDetails implements Serializable {
	
	private Long ADID;
	private String articleName;
	private String articleURL;
	private SupplierCategory supplierCategory;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADID")
	public Long getADID() {
		return ADID;
	}
	public void setADID(Long aDID) {
		ADID = aDID;
	}
	
	@Column(name="article_name", nullable=true, length=100)
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	
	@Column(name="article_URL", nullable=true, length=100)
	public String getArticleURL() {
		return articleURL;
	}
	public void setArticleURL(String articleURL) {
		this.articleURL = articleURL;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FSCID", nullable=false)
	@JsonIgnore
	public SupplierCategory getSupplierCategory() {
		return supplierCategory;
	}
	public void setSupplierCategory(SupplierCategory supplierCategory) {
		this.supplierCategory = supplierCategory;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ADID == null) ? 0 : ADID.hashCode());
		result = prime * result + ((articleName == null) ? 0 : articleName.hashCode());
		result = prime * result + ((articleURL == null) ? 0 : articleURL.hashCode());
		result = prime * result + ((supplierCategory == null) ? 0 : supplierCategory.hashCode());
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
		ArticleDetails other = (ArticleDetails) obj;
		if (ADID == null) {
			if (other.ADID != null)
				return false;
		} else if (!ADID.equals(other.ADID))
			return false;
		if (articleName == null) {
			if (other.articleName != null)
				return false;
		} else if (!articleName.equals(other.articleName))
			return false;
		if (articleURL == null) {
			if (other.articleURL != null)
				return false;
		} else if (!articleURL.equals(other.articleURL))
			return false;
		if (supplierCategory == null) {
			if (other.supplierCategory != null)
				return false;
		} else if (!supplierCategory.equals(other.supplierCategory))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ArticleDetails [ADID=" + ADID + ", articleName=" + articleName + ", articleURL=" + articleURL
				+ ", supplierCategory=" + supplierCategory + "]";
	}
	
}
