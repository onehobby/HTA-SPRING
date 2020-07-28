package kr.co.jhta.dto;

import java.util.Date;

public class BlogDto {
	
	private int no;
	private String title;
	private String writer;
	private int likes;
	private int commentCounts;
	private Date blogCreateDate;
	private String content;
	
	public BlogDto() {}

	public BlogDto(int no, String title, String writer, int likes, int commentCounts, Date blogCreateDate,
			String content) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.likes = likes;
		this.commentCounts = commentCounts;
		this.blogCreateDate = blogCreateDate;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getCommentCounts() {
		return commentCounts;
	}

	public void setCommentCounts(int commentCounts) {
		this.commentCounts = commentCounts;
	}

	public Date getBlogCreateDate() {
		return blogCreateDate;
	}

	public void setBlogCreateDate(Date blogCreateDate) {
		this.blogCreateDate = blogCreateDate;
	}
	

}
