package kr.co.jhta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.co.jhta.vo.Book;

public class BookDao {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insertBook(Book book) throws SQLException {
		
		String sql = "insert into sample_books(book_no, book_title, book_writer, book_publisher, book_genre, book_price, book_discount_price ) "
				+ "values(sample_book_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		// db access 전처리
		Connection connection = dataSource.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		// 파라미터값 바인딩
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getPublisher());
		pstmt.setString(4, book.getGenre());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());
		
		// 쿼리실행
		pstmt.executeUpdate();
		
		// access 후처리
		pstmt.close();
		connection.close();
		
	}
	
	public void deleteBook(int bookNo) throws SQLException {
		
		String sql = "delete from sample_books where book_no = ?";
		
		// db access 전처리
		Connection connection = dataSource.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		// 파라미터값 바인딩
		pstmt.setInt(1, bookNo);
		
		// 쿼리실행
		pstmt.executeUpdate();
		
		// db access 후처리
		pstmt.close();
		connection.close();
		
		
	}
	
	public void updateBook(Book book) throws SQLException {
		
		String sql = "update sample_books set book_price = ?, book_discount_price = ? where book_no = ?";
		
		// db access 전처리
		Connection connection = dataSource.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		// 파라미터값 바인딩
		pstmt.setInt(1, book.getPrice());
		pstmt.setInt(2, book.getDiscountPrice());
		pstmt.setInt(3, book.getNo());
		
		// 쿼리실행
		pstmt.executeUpdate();
		
		// db access 후처리
		pstmt.close();
		connection.close();
		
	}
	
	public Book getBookByNo(int bookNo) throws SQLException {
		
		String sql = "select * from sample_books where book_no = ?";
		
		Book book = null;
		
		// db access 전처리
		Connection connection = dataSource.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		// 파라미터값 바인딩
		pstmt.setInt(1, bookNo);
		
		// 쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setWriter(rs.getString("book_writer"));
			book.setGenre(rs.getString("book_genre"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountPrice(rs.getInt("book_discount_price"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return book;
	}
	
	public List<Book> getAllBooks() throws SQLException {
		
		String sql = "select * from sample_books order by book_title";
		List<Book> books = new ArrayList<Book>();
		
		// db access 전처리
		Connection connection = dataSource.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		// 파라미터값 바인딩
		
		// 쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		// 조회결과 처리
		while(rs.next()) {
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setWriter(rs.getString("book_writer"));
			book.setGenre(rs.getString("book_genre"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountPrice(rs.getInt("book_discount_price"));
			
			books.add(book);
		}
		
		// db access 후처리
		rs.close();
		pstmt.close();
		connection.close();
		
		return books;
	}

}
