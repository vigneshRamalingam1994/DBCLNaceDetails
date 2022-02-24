package com.nace.common.utils;

public enum Topic {

	Order("ORDER", 1);

	private final String name;

	private final int code;

	private Topic(String name, int code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

}
