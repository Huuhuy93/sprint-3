package book.demo.repositories;

import book.demo.dtos.IBookDto;
import book.demo.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;


public interface IBookRepository extends JpaRepository<Book, Long> {
    @Query(value = "select book.id as id, book.book_name as name, book.author as author," +
            " book.price as price, book.image as image, category.id as idCategory , category.name as nameCategory" +
            " from book join category on book.category_id = category.id" +
            " where delete_flag = 0 and book_name like concat('%', :keyName ,'%') "
            ,
            countQuery = "select book.id as id, book.book_name as name, book.author as author," +
                    " book.price as price, book.image as image, category.id as idCategory , category.name as nameCategory" +
                    " from book join category on book.category_id = category.id" +
                    " where delete_flag = 0 and book_name like concat('%', :keyName ,'%') ",
            nativeQuery = true )
    Page<IBookDto> pageFindAll(Pageable pageable, @Param("keyName") String keyName);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO book (`id`,`book_name`, `author`, " +
            "`quantity`,`image`, `discount`,`price`,`description` " +
            " VALUES (:#{#book.id},:#{#book.book_name},:#{#book.author}," +
            ":#{#book.deleteFlag},:#{#book.quantity},:#{#book.image}," +
            ":#{#book.discount},:#{#book.price},:#{#book.description}", nativeQuery = true)
    void createBook(Book book);

    @Transactional
    @Modifying
    @Query(value = "update book set delete_flag = 1 where book.id = :id ; ", nativeQuery = true)
    void saveDelete(@PathVariable("id") Long id);

}
