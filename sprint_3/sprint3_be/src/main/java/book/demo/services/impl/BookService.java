package book.demo.services.impl;

import book.demo.dtos.IBookDto;
import book.demo.models.Book;
import book.demo.repositories.IBookRepository;
import book.demo.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<IBookDto> findAllBook(Pageable pageable, String keyName) {
        return iBookRepository.pageFindAll(pageable, keyName);
    }

    @Override
    public void save(Book book) {
        iBookRepository.createBook(book);
    }

}
