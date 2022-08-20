package com.gelvides.ttforlanit.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class PersonDto extends MainDto {

    @NotBlank
    private String name;


    @NotNull
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthdate;

    private List<CarDto> cars;

    public PersonDto(long id,
                     String name,
                     @JsonFormat(shape = JsonFormat.Shape.STRING,
                             pattern = "dd.MM.yyyy",
                     lenient = OptBoolean.FALSE)
                     Date birthdate) {
        super(id);
        this.name = name;
        this.birthdate = birthdate;
    }
}
