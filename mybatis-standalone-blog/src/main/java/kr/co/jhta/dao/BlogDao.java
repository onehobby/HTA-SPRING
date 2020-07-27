package kr.co.jhta.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.jhta.util.MybatisUtil;
import kr.co.jhta.vo.Blog;

public class BlogDao {
	
	public void insertBlog(Blog blog) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			session.insert("insertBlog", blog);
			session.commit();
		} finally {
			session.close();
		}
	}

	/*
	public List<BlogDto> getAllBlogs() {
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			session.selectList("getAllBlogs");
		} finally {
			session.close();
		}
		
		
	}
	*/
	
}