package service;

import model.BookDTO;
import repository.AddBookRepository;

public class AddBookServiceImpl implements AddBookService {

    AddBookRepository addBookRepository = new AddBookRepository();
    public boolean addBook(BookDTO bookDTO) {
        return addBookRepository.addBooks(bookDTO);

    }
}
