package ru.kuyamaks.projects.library.dao.book;

import org.springframework.jdbc.core.RowMapper;
import ru.kuyamaks.projects.library.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setReaderId(resultSet.getInt("reader_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setPublicationYear(resultSet.getString("publication_year"));

        return book;
    }
}
