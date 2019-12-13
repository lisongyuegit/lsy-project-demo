package com.lsytest.demo.entity;

public class TestEntity {
	/** 姓名 */
	private String name = "";

	/** 身高 */
	private Integer height;

	/** 体重 */
	private Integer weight;

	/** 电话 */
	private String tel = "";

	/** 性别 */
	private String sax = "";

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSax() {
		return sax;
	}

	public void setSax(String sax) {
		this.sax = sax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
