package kr.co.jhta.vo;

import java.util.Date;

public class Blog {
	
	private int no;
	private String title;
	private String writer;
	private String content;
	private int likes;
	private int commnetCounts;
	private Date createDate;
	
	public Blog() {
		// TODO Auto-generated constructor stub
	}

	public Blog(int no, String title, String writer, String content, int likes, int commnetCounts, Date createDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.likes = likes;
		this.commnetCounts = commnetCounts;
		this.createDate = createDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getCommnetCounts() {
		return commnetCounts;
	}

	public void setCommnetCounts(int commnetCounts) {
		this.commnetCounts = commnetCounts;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
