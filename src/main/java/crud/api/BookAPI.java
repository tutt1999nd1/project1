package crud.api;

import crud.dao.BookDAO;
import crud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookAPI {
    @Autowired
    BookDAO bookDAO;

    @GetMapping("/tesst")
    public String getAll1(){
        return bookDAO.getAll().size()+"";
    }

    @GetMapping("/getall")
    public List<Book> getAll(){
        return bookDAO.getAll();
    }

    @GetMapping("/get_book_by_id/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookDAO.getBook(id);
    }

    @DeleteMapping("/delete/{id}")
    public void del(@PathVariable("id") int id){
        bookDAO.delete(id);
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book){
         bookDAO.save(book);
    }

    @PostMapping("/insertbatch")
    public void addBooks(@RequestBody List<Book> books){
        bookDAO.insertBatch(books);
    }

    @PutMapping("/update/{id}")
    public void updateBook(@RequestBody Book book){
        bookDAO.edit(book);
    }

    @DeleteMapping("/deletebatch")
    public void delBatch(@RequestBody int[] ids){
            bookDAO.dels(ids);
    }

    @PutMapping("/updateBatch")
    public void updateBatch(@RequestBody List<Book> books){
        bookDAO.updateBatch(books);
    }

}
