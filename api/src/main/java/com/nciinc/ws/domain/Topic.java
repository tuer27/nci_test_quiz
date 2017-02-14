package com.nciinc.ws.domain;

import java.util.Date;
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
import com.nciinc.ws.dto.TopicInfo;

@Entity
@Table(name="topic", schema="ncitest")
public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "category_id")
	private int categoryId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id", insertable=false, updatable=false)
	private TopicCategory category;
	
	
	@Column(name = "owner_id")
	private int ownerId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner_id", insertable=false, updatable=false)
	private Owner owner;

	private String name;

	private String description;
	
	private boolean activeFlag;

	@Column(name = "create_ts", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "update_ts", insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	public Topic() {
		updateDate = new Date();
	}

	public Topic(TopicInfo input) {
		name = input.getName();
		description = input.getDescription();
		activeFlag = input.getActiveFlag();
		categoryId = input.getCategoryId();
		ownerId = input.getOwnerId();
		updateDate = new Date();
	}

	public void update(TopicInfo input) {
		name = input.getName();
		description = input.getDescription();
		activeFlag = input.getActiveFlag();
		ownerId = input.getOwnerId();
		categoryId = input.getCategoryId();
		updateDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public TopicCategory getCategory() {
		return category;
	}

	public void setCategory(TopicCategory category) {
		this.category = category;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getActiveFlag(){
		return activeFlag;
	}
	
	public void setActiveFlag(boolean activeFlag){
		this.activeFlag = activeFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
