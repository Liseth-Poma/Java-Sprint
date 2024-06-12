package com.liseth.angular.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_formulario;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Date is required")
    private Date date;

    @NotEmpty(message = "Text is required")
    @Size(max = 200, message = "Text must be less than or equal to 200 characters")
    private String text;

    @NotEmpty(message = "Category is required")
    private String category;

    @NotEmpty(message = "Gender is required")
    private String gender;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
}
