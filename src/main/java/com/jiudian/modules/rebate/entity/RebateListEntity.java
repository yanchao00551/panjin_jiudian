package com.jiudian.modules.rebate.entity;

public class RebateListEntity {

	//消费来源
	private String source;
	
	//获利对象
	private String dest;
	
	private String rkey;
	
	//返润比例
	private String points;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getRkey() {
		return rkey;
	}

	public void setRkey(String rkey) {
		this.rkey = rkey;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}
}
