package com.vam.model;

public class CateFilterDTO {

	/* 카테고리 등급 */
	private int tier;
	
	/* 카테고리 이름 */
	private String cateName;
	
	/* 카테고리 넘버 */
	private String cateCode;
	
	/* 상위 카테고리 */
	private String cateParent;
	
	/* 카테고리 상품 수 */
	private int cateCount;
	
	/* 국내,국외 분류 */
	private String cateGroup;

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
		this.cateGroup = cateCode.split("")[0];
	}

	public String getCateParent() {
		return cateParent;
	}

	public void setCateParent(String cateParent) {
		this.cateParent = cateParent;
	}

	public int getCateCount() {
		return cateCount;
	}

	public void setCateCount(int cateCount) {
		this.cateCount = cateCount;
	}

	public String getCateGroup() {
		return cateGroup;
	}

	public void setCateGroup(String cateGroup) {
		this.cateGroup = cateGroup;
	}

	@Override
	public String toString() {
		return "CateFilterDTO [tier=" + tier + ", cateName=" + cateName + ", cateCode=" + cateCode + ", cateParent="
				+ cateParent + ", cateCount=" + cateCount + ", cateGroup=" + cateGroup + "]";
	}


}
