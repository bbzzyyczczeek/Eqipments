package com.example.eqipments.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = ("Uzytkownk o takim peselu istnieje"))
public class DuplicatePeselExeption extends RuntimeException{
}
