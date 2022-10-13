package me.raylleremery.springvalidationsexample.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApplicationControllerAdvice {

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun methodArgumentHandling(ex: MethodArgumentNotValidException): List<String> {

        val errorList: MutableList<String> = mutableListOf()

        for (error in ex.allErrors)
            errorList.add(error.defaultMessage ?: "")

        return errorList
    }
}