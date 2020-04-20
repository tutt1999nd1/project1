package crud.dao;
import crud.map.BookMaper;
import crud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void insertBatch(final List<Book> books){

        jdbcTemplate.batchUpdate("INSERT INTO book2 (id,name,code) VALUES (?, ?,?)",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setInt(1, books.get(i).getId());
                        ps.setString(2, books.get(i).getName());
                        ps.setString(3, books.get(i).getCode());
                    }
                    public int getBatchSize() {
                        return books.size();
                    }
                });
    }



    public List<Book> getAll(){
        String query="Select *from book2";
        return  jdbcTemplate.query(query,new BookMaper());

    }

    public void delete(int id){
        String query="DELETE from book2 WHERE id ="+id;
          jdbcTemplate.update(query);
    }

    public void save(Book book){
        String query="INSERT INTO book2(id,name,code) VALUES(?,?,?)";
        jdbcTemplate.update(query,book.getId(),book.getName(),book.getCode());
    }

    public Book getBook(int id){
        String query="Select *from book2 where id=?";
        return jdbcTemplate.queryForObject(query,new BookMaper(),id);
    }

    public void edit(Book book) {
        String query="UPDATE book2 SET  code= ?, name=? WHERE id=?";
        jdbcTemplate.update(query,book.getCode(),book.getName(),book.getId());
    }

    public void dels(int[] ids) {

        jdbcTemplate.batchUpdate("DELETE from book2 where id=?",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setInt(1, ids[i]);
                    }
                    public int getBatchSize() {
                        return ids.length;
                    }
                });
    }

    public void updateBatch(List<Book> books) {
        jdbcTemplate.batchUpdate("UPDATE  book2 SET code=?,name=? where id=?",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, books.get(i).getCode());
                        ps.setString(2, books.get(i).getName());
                        ps.setInt(3, books.get(i).getId());
                    }
                    public int getBatchSize() {
                        return books.size();
                    }
                });
    }
}
