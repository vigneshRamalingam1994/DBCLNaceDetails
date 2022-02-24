package com.nace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "nacedetails")
@Entity
public class OrderDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orderid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderid;

	@Column(name = "Level")
	private int level;

	@Column(name = "Code")
	private String code;

	@Column(name = "Parent")
	private String parent;

	@Column(name = "Description")
	private String description;

	@Column(name = "Includes")
	private String includes;

	@Column(name = "AddOns")
	private String addons;

	@Column(name = "Rulings")
	private String rulings;

	@Column(name = "Excludes")
	private String excludes;

	@Column(name = "IsicRef")
	private String isicref;

	public OrderDetails() {
	}

	public OrderDetails(long orderid, int level, String code, String parent, String description, String includes,
			String addons, String rulings, String excludes, String isicref) {
		super();
		this.orderid = orderid;
		this.level = level;
		this.code = code;
		this.parent = parent;
		this.description = description;
		this.includes = includes;
		this.addons = addons;
		this.rulings = rulings;
		this.excludes = excludes;
		this.isicref = isicref;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIncludes() {
		return includes;
	}

	public void setIncludes(String includes) {
		this.includes = includes;
	}

	public String getAddons() {
		return addons;
	}

	public void setAddons(String addons) {
		this.addons = addons;
	}

	public String getRulings() {
		return rulings;
	}

	public void setRulings(String rulings) {
		this.rulings = rulings;
	}

	public String getExcludes() {
		return excludes;
	}

	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}

	public String getIsicref() {
		return isicref;
	}

	public void setIsicref(String isicref) {
		this.isicref = isicref;
	}

}
