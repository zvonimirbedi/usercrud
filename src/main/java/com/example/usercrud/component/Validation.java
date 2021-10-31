package com.example.usercrud.component;

import com.example.usercrud.dto.UserDto;
import com.example.usercrud.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.usercrud.Constants.FIELD_LENGTH_SIZE;
import static com.example.usercrud.Constants.FIELD_MUST_NOT_BE_BLANK;

@Component
public class Validation {

    public List<String> userDtoValidation(UserDto userDto) {
        List<String> errors = new ArrayList<>();
        if(userDto.getFirstName() == null)
            errors.add(FIELD_MUST_NOT_BE_BLANK);
        else if(userDto.getFirstName() != null && userDto.getFirstName().length() > 50)
            errors.add(FIELD_LENGTH_SIZE);

        if(userDto.getLastName() == null)
            errors.add(FIELD_MUST_NOT_BE_BLANK);
        else if(userDto.getLastName() != null && userDto.getLastName().length() > 500)
            errors.add(FIELD_LENGTH_SIZE);

        if(userDto.getUsername() == null)
            errors.add(FIELD_MUST_NOT_BE_BLANK);
        else if(userDto.getUsername() != null && userDto.getUsername().length() > 50)
            errors.add(FIELD_LENGTH_SIZE);

        if(userDto.getAge() == null)
            errors.add(FIELD_MUST_NOT_BE_BLANK);
        else if(userDto.getAge() != null && (userDto.getAge() < 18 || userDto.getAge() > 100))
            errors.add(FIELD_LENGTH_SIZE);

        return errors;
    }

    public List<String> userValidation(User user) {
        List<String> errors = new ArrayList<>();
        if(user.getFirstName() == null)
            errors.add(FIELD_MUST_NOT_BE_BLANK);
        else if(user.getFirstName() != null && user.getFirstName().length() > 50)
            errors.add(FIELD_LENGTH_SIZE);

        if(user.getLastName() == null)
            errors.add(FIELD_MUST_NOT_BE_BLANK);
        else if(user.getLastName() != null && user.getLastName().length() > 500)
            errors.add(FIELD_LENGTH_SIZE);

        if(user.getUsername() == null)
            errors.add(FIELD_MUST_NOT_BE_BLANK);
        else if(user.getUsername() != null && user.getUsername().length() > 50)
            errors.add(FIELD_LENGTH_SIZE);

        if(user.getAge() == null)
            errors.add(FIELD_MUST_NOT_BE_BLANK);
        else if(user.getAge() != null && (user.getAge() < 18 || user.getAge() > 100))
            errors.add(FIELD_LENGTH_SIZE);

        return errors;
    }


}
