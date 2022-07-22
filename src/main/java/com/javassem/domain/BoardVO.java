package com.javassem.domain;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//VO(Value Object) = DTO (Data Transfer Object)

//@Setter
//@Getter
//@NoArgsConstructor
@Data	// @Setter + @Getter + @NoArgsConstructor + @ToString +...
public class BoardVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;


//	public int getSeq() {
//		return seq;
//	}
//
//	public void setSeq(int seq) {
//		this.seq = seq;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getWriter() {
//		return writer;
//	}
//
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public Date getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(Date regDate) {
//		this.regDate = regDate;
//	}
//
//	public int getCnt() {
//		return cnt;
//	}
//
//	public void setCnt(int cnt) {
//		this.cnt = cnt;
//	}

}