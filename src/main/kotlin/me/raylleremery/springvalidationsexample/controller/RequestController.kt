package me.raylleremery.springvalidationsexample.controller

import me.raylleremery.springvalidationsexample.controller.request.DataRequest
import me.raylleremery.springvalidationsexample.controller.response.DataResponse
import me.raylleremery.springvalidationsexample.controller.response.ResponseIssue
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class RequestController {

    @PostMapping("issue")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun requestIssue(@Valid @RequestBody dataRequest: DataRequest): ResponseIssue {
        return ResponseIssue(
            data = DataResponse("retorno ok")
        )
    }
}