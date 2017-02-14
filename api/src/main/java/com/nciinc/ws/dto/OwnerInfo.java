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
	
	private Date createDate;

	public OwnerInfo() {
	}

	public OwnerInfo(Owner owner) {
		id = owner.getId();
		name = owner.getName();
		createDate = owner.getCreateDate();
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
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}





}
