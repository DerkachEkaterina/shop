package com.derkachekaterina.shop.rest.advice;

import com.derkachekaterina.shop.exception.CakeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice//указывает, что методы данного компонента будут использоваться сразу несколькими контроллерами
public class CakeAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)//указать статус ответа метода контроллера
    @ExceptionHandler(CakeNotFoundException.class)//обрабатывает исключение, произошедшее в контроллере, как обычный запрос.
    public void cakeNotFound() {

    }
}
