package ru.kuyamaks.projects.library.dao.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kuyamaks.projects.library.dao.reader.ReaderRowMapper;
import ru.kuyamaks.projects.library.models.Book;
import ru.kuyamaks.projects.library.models.Reader;

import java.util.List;

@Component
public class BookDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BookRowMapper());
    }

    public Book show(int bookId) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id = ?", new BookRowMapper(), bookId).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, author, publication_year) VALUES (?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }

    public void update(int bookId, Book updatedBook) {
        jdbcTemplate.update("UPDATE book SET title = ?, author = ?, publication_year = ? WHERE id = ?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getPublicationYear(), bookId);
    }

    public void delete(int bookId) {
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", bookId);
    }

    public void assignBook(int readerId, int bookId) {
        jdbcTemplate.update("UPDATE book SET reader_id = ? WHERE id = ?", readerId, bookId);
    }

    public void freeBook(int bookId) {
        jdbcTemplate.update("UPDATE book SET reader_id = NULL WHERE id = ?", bookId);
    }

    public int getReaderIdByBookId(int bookId) {
        Book book = show(bookId);
        if (book == null || book.getReaderId() == 0) {
            return 0;
        }

        return book.getReaderId();
    }
}
