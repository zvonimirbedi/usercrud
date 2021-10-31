package com.example.usercrud.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import static com.example.usercrud.Constants.*;


@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(max = 50, message = FIELD_LENGTH_SIZE)
    @NotBlank(message = FIELD_MUST_NOT_BE_BLANK)
    @NotNull(message = FIELD_MUST_NOT_BE_BLANK)
    @Column(name = "username", length = 250, nullable = false)
    private String username;

    @Size(max = 50, message = FIELD_LENGTH_SIZE)
    @NotBlank(message = FIELD_MUST_NOT_BE_BLANK)
    @NotNull(message = FIELD_MUST_NOT_BE_BLANK)
    @Column(name = "first_name", length = 250, nullable = false)
    private String firstName;

    @Size(max = 500, message = FIELD_LENGTH_SIZE)
    @NotBlank(message = FIELD_MUST_NOT_BE_BLANK)
    @NotNull(message = FIELD_MUST_NOT_BE_BLANK)
    @Column(name = "last_name", length = 250, nullable = false)
    private String lastName;


    @NotNull(message = FIELD_MUST_NOT_BE_BLANK)
    @Column(name = "age", nullable = false)
    @Min(value = 18, message = FIELD_LENGTH_SIZE)
    @Max(value = 100, message = FIELD_LENGTH_SIZE)
    private Integer age;

    @Column(name = "description", length = 250, nullable = true)
    private String description;
}
