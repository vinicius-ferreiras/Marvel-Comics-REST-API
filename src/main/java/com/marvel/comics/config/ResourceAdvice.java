package com.marvel.comics.config;

import com.marvel.comics.config.ErroDeFormularioDto;
import com.marvel.comics.exception.ComicNotFoundException;
import com.marvel.comics.exception.UsuarioNotFoundException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ResourceAdvice {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsuarioNotFoundException.class)
    public String usuarioNotFound(){
        return "Usuario não encontrado";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ComicNotFoundException.class, FeignException.class})
    public String comicNotFound(){
        return "Comic não encontrado";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDto> formHandle(MethodArgumentNotValidException exception){
        List<ErroDeFormularioDto> errosDeFormularioDto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            ErroDeFormularioDto erro = new ErroDeFormularioDto(fieldError.getField(), mensagem);
            errosDeFormularioDto.add(erro);
        });
        return errosDeFormularioDto;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public String dataHandle(DateTimeParseException exception){
        return "Insira uma data válida (YYYY-MM-DD)";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class, SQLIntegrityConstraintViolationException.class})
    public String cpfEEmailHandle(){
        return "Email ou CPF já cadastrados";
    }
}
