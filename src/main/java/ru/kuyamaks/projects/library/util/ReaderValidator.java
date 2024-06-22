package ru.kuyamaks.projects.library.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kuyamaks.projects.library.dao.reader.ReaderDAO;
import ru.kuyamaks.projects.library.models.Reader;

@Component
public class ReaderValidator implements Validator {
    private ReaderDAO readerDAO;

    @Autowired
    public ReaderValidator(ReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Reader.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Reader reader = (Reader) o;

        if (readerDAO.findByFullName(reader.getFullName()).isPresent()) {
            errors.rejectValue("fullName", "", "Such reader already exists");
        }
    }
}
