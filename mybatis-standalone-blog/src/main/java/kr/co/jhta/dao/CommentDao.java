package kr.co.jhta.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.jhta.util.MybatisUtil;
import kr.co.jhta.vo.Comment;

public class CommentDao {
	
	public void insertComment(Comment comment) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			session.insert("insertComment", comment);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public List<Comment> getCommentsByBlogNo(int blogNo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			return session.selectList("getCommentsByBlogNo", blogNo);
		} finally {
			session.close();
		}
	}

	
}
