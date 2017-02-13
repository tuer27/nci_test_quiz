package com.nciinc.ws.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private Set<Owner> owners = new HashSet<Owner>(0);

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
		owners = input.getOwners();
		updateDate = new Date();
	}

	public void update(TopicInfo input) {
		name = input.getName();
		description = input.getDescription();
		activeFlag = input.getActiveFlag();
		owners = input.getOwners();
		categoryId = input.getCategoryId();
		updateDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }
}
