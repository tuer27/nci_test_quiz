package com.nciinc.ws.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nciinc.ws.domain.Owner;

public class OwnerInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotNull
	@Size(max=255)
	private String name;
	
	private int topicId;
	private TopicInfo topic;
	
	private Date createDate;
	private Date updateDate;

	public OwnerInfo() {
	}

	public OwnerInfo(Owner owner) {
		id = owner.getId();
		name = owner.getName();
		
		topicId = owner.getTopic().getId();
		topic = new TopicInfo(owner.getTopic());
		
		createDate = owner.getCreateDate();
		updateDate = owner.getUpdateDate();
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
	
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public TopicInfo getCategory() {
		return topic;
	}

	public void setCategory(TopicInfo topic) {
		this.topic = topic;
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
