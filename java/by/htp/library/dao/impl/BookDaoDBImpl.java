package by.htp.library.dao.impl;

import static by.htp.library.dao.impl.util.DBConnectionHelper.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.mysql.cj.api.xdevapi.ColumnDefinition.StaticColumnDefinition; 

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDao;

public class BookDaoDBImpl implements BookDao {

	private static final String SQL_SELECT_BOOKS="select * from book";
	
	public void create(Book entity) {

	}

	public Book read(int id) {

		return null;
	}

	public List<Book> readAll() {
		
		
		List<Book> books=new ArrayList<>();
		Connection connection = connect();
	
		try {
			Statement st=connection.createStatement();// запросы к базе данных
			ResultSet rs=st.executeQuery(SQL_SELECT_BOOKS); // обьект результата коллекции данных
		
			
			
			while(rs.next()) {
				Book book= new Book();
				book.setId(rs.getInt("id"));//select*from book запрос по номеру колонки через хейди после запроса
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
				
				books.add(book);
			}
			
			
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		disconnect(connection);
		
		return books;
	}

	public void update(Book entity) {

	}

	public void delete(int id) {

	}

}
