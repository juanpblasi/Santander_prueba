package com.santander.prueba.exception

import com.santander.prueba.dto.ApiError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(RequestException::class)
    fun handleRequestException(ex: RequestException, request: WebRequest): ResponseEntity<ApiError> {
        val error = ApiError(ex.code, ex.message)
        return ResponseEntity(error, HttpStatus.valueOf(ex.status))
    }
}
