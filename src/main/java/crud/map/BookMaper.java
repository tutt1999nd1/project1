package crud.map;

import crud.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMaper implements RowMapper<Book> {
    public Book mapRow(ResultSet resultSet, int row) throws SQLException {
        Book book= new Book();
        book.setId(resultSet.getInt("id"));
        book.setCode(resultSet.getString("code"));
        book.setName(resultSet.getString("name"));
        return book;
    }
}
