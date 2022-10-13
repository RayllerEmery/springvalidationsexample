package me.raylleremery.springvalidationsexample.controller.request

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy::class)
data class DataRequest(
    @field:NotNull
    val receivableType: ReceivableType,
    @field:[Valid NotNull]
    val data: Payment
)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(value = [
    Type(value = IssueRequest::class, name = "issue_request"),
    Type(value = PixRequest::class, name = "pix_request")
])
sealed class Payment {
    abstract val payer: Payer
}

data class Payer(
    @field: [NotEmpty]
    val name: String,
    @field: [NotEmpty Size(max = 50)]
    val document: String
)

enum class ReceivableType {
    BANKSLIP, PIX
}
