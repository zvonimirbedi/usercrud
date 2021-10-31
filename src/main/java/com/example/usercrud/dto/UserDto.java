package com.example.usercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

import static com.example.usercrud.Constants.*;


@Data
@AllArgsConstructor
public class UserDto {

    @Size(max = 50, message = FIELD_LENGTH_SIZE)
    @NotBlank(message = FIELD_MUST_NOT_BE_BLANK)
    @NotNull(message = FIELD_MUST_NOT_BE_BLANK)
    private String username;

    @Size(max = 50, message = FIELD_LENGTH_SIZE)
    @NotBlank(message = FIELD_MUST_NOT_BE_BLANK)
    @NotNull(message = FIELD_MUST_NOT_BE_BLANK)
    private String firstName;

    @Size(max = 500, message = FIELD_LENGTH_SIZE)
    @NotBlank(message = FIELD_MUST_NOT_BE_BLANK)
    @NotNull(message = FIELD_MUST_NOT_BE_BLANK)
    private String lastName;

    @NotNull(message = FIELD_MUST_NOT_BE_BLANK)
    @Min(value = 18, message = FIELD_LENGTH_SIZE)
    @Max(value = 100, message = FIELD_LENGTH_SIZE)
    private Integer age;

    private String description;
}
