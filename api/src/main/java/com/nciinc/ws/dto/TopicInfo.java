package com.nciinc.ws.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nciinc.ws.domain.Topic;

public class TopicInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotNull
	@Size(max=255)
	private String name;

	@NotNull
	private String description;
	
	@NotNull
	private boolean activeFlag;

	private int categoryId;
	
	private int ownerId;

	@Valid
	private TopicCategoryInfo category;
	
	@Valid
	private OwnerInfo owner;

	private Date createDate;
	private Date updateDate;

	public TopicInfo() {
	}

	public TopicInfo(Topic topic) {
		id = topic.getId();
		name = topic.getName();
		categoryId = topic.getCategory().getId();
		category = new TopicCategoryInfo(topic.getCategory());
		description = topic.getDescription();
		activeFlag = topic.getActiveFlag();
		
		ownerId = topic.getOwner().getId();
		owner = new OwnerInfo(topic.getOwner());
		createDate = topic.getCreateDate();
		updateDate = topic.getUpdateDate();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean getActiveFlag(){
		return activeFlag;
	}
	
	public void setActiveFlag(boolean activeFlag){
		this.activeFlag = activeFlag;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public TopicCategoryInfo getCategory() {
		return category;
	}

	public void setCategory(TopicCategoryInfo category) {
		this.category = category;
	}
	
	
	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public OwnerInfo getOwner(){
		return owner;
	}
	
	public void setOwners(OwnerInfo owner){
		this.owner = owner;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
