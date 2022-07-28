package book.demo.services;

import book.demo.dtos.IBookDto;
import book.demo.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBookService {
    Page<IBookDto> findAllBook(Pageable pageable, String keyName);

    void save(Book book);
}
