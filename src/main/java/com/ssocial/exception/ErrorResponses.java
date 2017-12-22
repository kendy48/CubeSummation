package com.ssocial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponses extends ErrorResponse {

    public static final ErrorResponses INTERNAL_SERVER_ERROR = new ErrorResponses("Ocurrio un error interno por favor trate de nuevo, si el problema persiste por favor contacte al administrador para la solucion del mismo", HttpStatus
        .INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());

    public static final ErrorResponses INVALID_SOLVE_CUBE_REQUEST = new ErrorResponses("Se requiere que ingrese los datos para la solucion del Cubo", HttpStatus
            .BAD_REQUEST, HttpStatus.BAD_REQUEST.value());

    public static final ErrorResponses INVALID_CASE_NUMBER = new ErrorResponses("Numero de casos invalidos debe ser un entero mayor a Cero y menor a o igual a 50", HttpStatus
            .BAD_REQUEST, HttpStatus.BAD_REQUEST.value());

    public static final ErrorResponses INVALID_MAIN_CASE_VALUES = new ErrorResponses("Por favor verifique que cada caso comience con dos enteros que indique el tamano de la matriz y el numero de operaciones", HttpStatus
            .BAD_REQUEST, HttpStatus.BAD_REQUEST.value());

    public static final ErrorResponses INVALID_CUBE_NUMBER = new ErrorResponses("Verique el tamano del cubo, deben ser un entero mayor a Cero y menor a o igual a 100", HttpStatus
            .BAD_REQUEST, HttpStatus.BAD_REQUEST.value());

    public static final ErrorResponses INVALID_OPERATION_NUMBER = new ErrorResponses("Verique que el tamano de las operaciones, deben ser un entero mayor a Cero y menor a o igual a 1000", HttpStatus
            .BAD_REQUEST, HttpStatus.BAD_REQUEST.value());

    public static final ErrorResponses INVALID_OPERATION_QUERY_PARAMS = new ErrorResponses("Verique que los parametros de las operaciones son validos", HttpStatus
            .BAD_REQUEST, HttpStatus.BAD_REQUEST.value());

    public static final ErrorResponses INVALID_VALUE_NUMBER = new ErrorResponses("Verifique los valores de que asignan, deben ser mayor a -10^9 y menor que 10^9", HttpStatus
            .BAD_REQUEST, HttpStatus.BAD_REQUEST.value());

    public ErrorResponses() {
    }


    public ErrorResponses(String message, HttpStatus httpStatus, Integer code) {
        super(message, httpStatus, code);
    }

}