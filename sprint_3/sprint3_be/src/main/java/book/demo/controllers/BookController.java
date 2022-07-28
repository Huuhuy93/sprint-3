package book.demo.controllers;

import book.demo.dtos.BookDto;
import book.demo.dtos.IBookDto;
import book.demo.models.Book;
import book.demo.models.Category;
import book.demo.models.ResponseObject;
import book.demo.services.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private IBookService iBookService;


    @GetMapping(value = {"/list"})
    public ResponseEntity<Page<IBookDto>> findAllBook(@PageableDefault(value = 7) Pageable pageable,
                                                          @RequestParam(required = false, value = "") String keyName ) {

        Page<IBookDto> bookDtoPage = iBookService.findAllBook(pageable, keyName);
        if (bookDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookDtoPage, HttpStatus.OK);
    }

    @PostMapping(value = {"/create"})
    public ResponseEntity<ResponseObject> createBook(@Valid @RequestBody BookDto bookDto,
                                                     BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();
        BookDto bookDtoErrors = new BookDto();
        bookDtoErrors.setiBookService(iBookService);
        bookDtoErrors.validate(bookDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        }

        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);

        Category category = new Category();
        BeanUtils.copyProperties(bookDto.getCategoryDto(), category);
        book.setDeleteFlag(false);

        this.iBookService.save(book);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
