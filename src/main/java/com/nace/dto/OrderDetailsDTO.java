package com.nace.dto;


public class OrderDetailsDTO {

	private static final long serialVersionUID = 1L;

	private long orderid;
	private int level;
	private String code;
	private String parent;
	private String description;
	private String includes;
	private String addons;
	private String rulings;
	private String excludes;
	private String isicref;

	public OrderDetailsDTO() {
	}

	public OrderDetailsDTO(long orderid, int level, String code, String parent, String description, String includes,
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
