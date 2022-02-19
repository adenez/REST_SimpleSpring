package ru.adenez.rest.restesting.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Client {

    @NotNull
    @NotEmpty
    //Automatic ID field
    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 20)
    //Client's name
    private String name;

    @Email
    //Client's email
    private String email;

    @Size(min = 6)
    //Client's phone
    private String phone;


}
