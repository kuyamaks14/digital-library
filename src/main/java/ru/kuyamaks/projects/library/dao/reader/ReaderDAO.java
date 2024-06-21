package ru.kuyamaks.projects.library.dao.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kuyamaks.projects.library.dao.book.BookRowMapper;
import ru.kuyamaks.projects.library.models.Book;
import ru.kuyamaks.projects.library.models.Reader;

import java.util.List;

@Component
public class ReaderDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ReaderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Reader> index() {
        return jdbcTemplate.query("SELECT * FROM reader", new ReaderRowMapper());
    }

    public Reader show(int readerId) {
        return jdbcTemplate.query("SELECT * FROM reader WHERE id = ?", new ReaderRowMapper(), readerId)
                .stream().findAny().orElse(null);
    }

    public void save(Reader reader) {
        jdbcTemplate.update("INSERT INTO reader(full_name, birth_year) VALUES (?, ?)",
                reader.getFullName(), reader.getBirthYear());
    }

    public void update(int readerId, Reader updatedReader) {
        jdbcTemplate.update("UPDATE reader SET full_name = ?, birth_year = ? WHERE id = ?",
                updatedReader.getFullName(), updatedReader.getBirthYear(), readerId);
    }

    public void delete(int readerId) {
        jdbcTemplate.update("DELETE FROM reader WHERE id = ?", readerId);
    }

    public List<Book> getBooks(int readerId) {
        return jdbcTemplate.query("SELECT * FROM book WHERE reader_id = ?", new BookRowMapper(), readerId);
    }
}
