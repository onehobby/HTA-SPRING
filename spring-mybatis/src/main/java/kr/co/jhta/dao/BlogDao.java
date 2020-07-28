package kr.co.jhta.dao;

import java.util.List;

import kr.co.jhta.vo.Blog;

public interface BlogDao {
	
	
	Blog getBlogByNo(int blogNo);
	
	List<Blog> getAllBlogs();
	
	List<Blog> getBlogsByWriter(String writer);
	
	void insertBlog(Blog blog);
	
	void updateBlog(Blog blog);
	
	void deleteBlog(Blog blog);
	

}
