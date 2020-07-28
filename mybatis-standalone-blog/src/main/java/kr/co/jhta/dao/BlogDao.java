package kr.co.jhta.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.jhta.dto.BlogDto;
import kr.co.jhta.util.MybatisUtil;
import kr.co.jhta.vo.Blog;

public class BlogDao {
	
	// 새 게시글 등록 기능
	public void insertBlog(Blog blog) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			session.insert("insertBlog", blog);
			session.commit();
		} finally {
			session.close();
		}
	}

	// 모든 게시글 조회기능
	public List<BlogDto> getAllBlogs() {
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			return session.selectList("getAllBlogs");
		} finally {
			session.close();
		}
	}
	
	// 게시글 상세 조회기능
	public BlogDto getBlogByNo(int blogNo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			return session.selectOne("getBlogByNo", blogNo);
		} finally {
			session.close();
		}
	}
	
}
