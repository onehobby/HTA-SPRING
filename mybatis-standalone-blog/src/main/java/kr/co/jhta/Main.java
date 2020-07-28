package kr.co.jhta;

import java.util.List;
import java.util.Scanner;

import kr.co.jhta.dao.BlogDao;
import kr.co.jhta.dao.CommentDao;
import kr.co.jhta.dao.UserDao;
import kr.co.jhta.dto.BlogDto;
import kr.co.jhta.vo.Blog;
import kr.co.jhta.vo.Comment;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		UserDao userDao = new UserDao();
		BlogDao blogDao = new BlogDao();
		CommentDao commentDao = new CommentDao();
		
		while(true) {
			
		
			System.out.println("[사용자 관리]");
			System.out.println("1.사용자 조회(아이디) 2. 모든 게시글 조회  3.게시글 상세조회  4.새 게시글 등록  5.댓글등록 6.전체삭제");
			System.out.println("-------------------------------------------------------------------");
			
			System.out.println("메뉴 선택>");
			int menuNo = scanner.nextInt();
			
			if (menuNo == 1) {
				System.out.println("[사용자 조회[아이디]");
				
				 System.out.println(userDao.getUserById(scanner.next()).getName());
				
			} else if (menuNo == 2) {
				System.out.println("[모든 게시글 조회]");
				
				List<BlogDto> blogs = blogDao.getAllBlogs();
				
				if (blogs.size() == 0) {
					
					System.out.println("등록된 게시글이 없습니다.");
					
				} else {
					
					for (BlogDto blog : blogs) {
						System.out.println("글번호: " + blog.getNo());
						System.out.println("제   목: " + blog.getTitle());
						System.out.println("작성자: " + blog.getWriter());
						System.out.println("조회수: " + blog.getLikes());
						System.out.println("댓글수: " + blog.getCommentCounts());
						System.out.println("생성일: " + blog.getBlogCreateDate());
					}
				}
				
			} else if (menuNo == 3) {
				System.out.println("[게시글 상세조회]");
				
				System.out.println("게시글 번호를 입력해주세요");
				int blogNo = scanner.nextInt();
				BlogDto blog = blogDao.getBlogByNo(blogNo);
				List<Comment> comments = commentDao.getCommentsByBlogNo(blogNo);
				
				if (comments.size() == 0) {
					
					System.out.println("등록된 게시글이 없습니다.");
					
				} else {
					
					System.out.println("글번호: " + blog.getNo());
					System.out.println("제   목: " + blog.getTitle());
					System.out.println("작성자: " + blog.getWriter());
					System.out.println("조회수: " + blog.getLikes());
					System.out.println("댓글수: " + blog.getCommentCounts());
					System.out.println("생성일: " + blog.getBlogCreateDate());
					
					for (Comment comment : comments) {
						System.out.println("댓글번  호 : " + comment.getNo());
						System.out.println("댓글작성자 : " + comment.getWriter());
						System.out.println("댓글내  용 : " + comment.getContent());
						System.out.println("댓글등록일: " + comment.getCreateDate());
					}
				}
				
			} else if (menuNo == 4) {
				System.out.println("[새 게시글 등록]");
				
				Blog blog = new Blog();
				
				System.out.print("제목을 입력해주세요");
				blog.setTitle(scanner.next());
				System.out.print("아이디를 입력해주세요");
				blog.setWriter(scanner.next());
				System.out.print("내용을 입력해주세요");
				blog.setContent(scanner.next());
				
				blogDao.insertBlog(blog);
				System.out.println("게시글 등록 완료");
				
			} else if (menuNo == 5) {
				System.out.println("[댓글 등록]");
				
				Comment comment = new Comment();
				
				System.out.print("게시글번호를 입력해주세요");
				comment.setBlogNo(scanner.nextInt());
				System.out.print("작성자를 입력해주세요");
				comment.setWriter(scanner.next());
				System.out.print("내용을 입력해주세요");
				comment.setContent(scanner.next());
				
				commentDao.insertComment(comment);
				
				System.out.println("등록이 완료되었습니다.");
				
			} else if (menuNo == 6) {
				System.out.println("[댓글조회]");
				
				
			} else if (menuNo == 0) {
				System.out.println("*** 프로그램 종료 ***");
				return;
			}	
		}
		
	}

}
