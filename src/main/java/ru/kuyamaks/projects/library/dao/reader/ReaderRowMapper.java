package ru.kuyamaks.projects.library.dao.reader;

import org.springframework.jdbc.core.RowMapper;
import ru.kuyamaks.projects.library.models.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderRowMapper implements RowMapper<Reader> {
    @Override
    public Reader mapRow(ResultSet resultSet, int i) throws SQLException {
        Reader reader = new Reader();

        reader.setId(resultSet.getInt("id"));
        reader.setFullName(resultSet.getString("full_name"));
        reader.setBirthYear(resultSet.getInt("birth_year"));

        return reader;
    }
}
