package com.dareProjects.gotoLinks.beans;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Component
@Entity
public class Links {

	@Id
	@GeneratedValue
	private int linkId;
	private String linkName;
	private String url;
	private int categoryId;
	private int userId;

	public Links() {}
		
	public Links(String linkName, String url, int categoryId, int userId) {
		this.linkName = linkName;
		this.url = url;
		this.categoryId = categoryId;
		this.userId = userId;
	}

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
