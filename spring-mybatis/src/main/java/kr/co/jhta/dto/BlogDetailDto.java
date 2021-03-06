package kr.co.jhta.dto;

import java.util.List;

import kr.co.jhta.vo.Blog;
import kr.co.jhta.vo.Comment;

public class BlogDetailDto {
	
	private Blog blog;
	private List<Comment> comments;
	
	public BlogDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public BlogDetailDto(Blog blog, List<Comment> comments) {
		super();
		this.blog = blog;
		this.comments = comments;
	}
	
	public Blog getBlog() {
		return blog;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
}
