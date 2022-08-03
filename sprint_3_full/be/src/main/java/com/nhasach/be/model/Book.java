package com.nhasach.be.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"cartDetailList", "flag"})

public class Book {
    @Id
    @GeneratedValue(generator = "book-id-generator")
    @GenericGenerator(name = "book-id-generator",
        parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "BK"),
        strategy = "com.nhasach.be.utils.IdentityCodeGenerator")
    private String bookId;
    private String name;
    private String code;
    private String translator;
    private Integer totalPage;
    private Double price;
    private Integer quantity;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private String dimension;
    private String publisherDate;
    private String img;
    private Boolean flag = true;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getPublisherDate() {
        return publisherDate;
    }

    public void setPublisherDate(String publisherDate) {
        this.publisherDate = publisherDate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<CartDetail> getCartDetailList() {
        return cartDetailList;
    }

    public void setCartDetailList(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisherId")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<CartDetail> cartDetailList;

    @Override
    public String toString() {
        return "Book{" + "bookId='" + bookId + '\'' + ", name='" + name + '\'' + ", code='" + code + '\'' + ", translator='" + translator + '\''
            + ", totalPage=" + totalPage + ", price=" + price + ", quantity=" + quantity + ", description='" + description + '\'' + ", dimension='"
            + dimension + '\'' + ", publisherDate='" + publisherDate + '\'' + ", img='" + img + '\'' + ", flag=" + flag + '}';
    }
}
