package kr.co.jhta.dao;

import java.util.List;

import kr.co.jhta.vo.Comment;

public interface BlogCommentDao {
	
	List<Comment> getCommentsByBlogNo(int blogNo);
	
	List<Comment> getCommentsByWriter(String writer);
	
	void insertComment(Comment comment);
	
	void deleteComment(int commentNo);

}