package com.jiudian.modules.member.form;

/**
 * 会员记录类型名称
 * @author KF-180419
 *
 */
public class MemberAccountRecordsTypeNameList {
	private Integer typeId;
	private String typeName;
	
	public MemberAccountRecordsTypeNameList(Integer typeId,String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
