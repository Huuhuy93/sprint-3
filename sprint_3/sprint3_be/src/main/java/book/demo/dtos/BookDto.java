package book.demo.dtos;

import book.demo.models.Category;
import book.demo.services.IBookService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Validator {

    private Long id;

    @NotBlank
    @Size(min = 5, max = 50)
    private String bookName;

    @NotBlank
    private String author;

    @NotBlank
    @Min(0)
    private String quantity;

    @NotBlank
    private String image;

    private Integer discount;

    @NotBlank
    @Min(0)
    private Double price;

    @NotBlank
    private String description;

    private boolean deleteFlag;

    private CategoryDto categoryDto;

    private IBookService iBookService;

    public IBookService getiBookService() {
        return iBookService;
    }

    public void setiBookService(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
