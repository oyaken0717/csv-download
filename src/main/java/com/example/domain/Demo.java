package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//■　@JsonPropertyOrder:任意の順番で出力したい場合必要です。
@JsonPropertyOrder({"ID", "名前", "概要", "更新日時"})
public class Demo {
	
	//■ @JsonProperty:設定した値が、CSV の1行目に出力
	//※設定しない場合はフィールド名が出力
    @JsonProperty("ID")
    private Long id;
    @JsonProperty("名前")
    private String name;
    @JsonProperty("概要")
    private String desc;
    @JsonProperty("更新日時")
    private Date modified;

    public Demo() {}

    public Demo(Long id, String name, String desc, Date modified) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.modified = modified;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + ", desc=" + desc + ", modified=" + modified + "]";
	}
}