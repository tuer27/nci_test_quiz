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
import com.nciinc.ws.dto.OwnerInfo;


@Entity
@Table(name="owner", schema="ncitest")
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "topic_id")
	private int topicId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="topic_id", insertable=false, updatable=false)
	private Topic topic;
	
	private String name;

	@Column(name = "create_ts", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "update_ts", insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	public Owner() {
		updateDate = new Date();
	}

	public Owner(OwnerInfo input) {
		name = input.getName();
		topicId = input.getTopicId();
		updateDate = new Date();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
