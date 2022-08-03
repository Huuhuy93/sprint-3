package com.nhasach.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@NoArgsConstructor
public class SignUpDto implements Validator {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String dateOfBirth;
    private String address;
    private Boolean gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpDto signUpDto = (SignUpDto) target;
        String name = signUpDto.getName();
        if (name == null) {
            errors.rejectValue("name", "name.required", "Tên không được để trống");
        } else if (!name.matches("^[a-zA-Z][\\w\\s]+$")) {
            errors.rejectValue("name", "name.regex", "Tên không được chứa kí tự đặc biệt");
        }
        String username = signUpDto.getUsername();
        if (username == null) {
            errors.rejectValue("username","username.invalid.required","Không được để trống");
        } else if (!username.matches("^[a-zA-Z]\\w{5,60}")) {
            errors.rejectValue("username","username.invalid.regex","Không hợp lệ");
        }
    }
}
