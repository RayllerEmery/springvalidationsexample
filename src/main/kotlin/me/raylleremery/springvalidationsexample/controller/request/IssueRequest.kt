package me.raylleremery.springvalidationsexample.controller.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonTypeName(value = "issue_request")
data class IssueRequest(
    @field: Valid
    override val payer: Payer,
    @field:[DecimalMin(value = "1.0")]
    val value: BigDecimal,
    @field: NotNull
    val billId: UUID,
    @field: [NotNull Valid]
    val receiver: IssueReciver,
    @JsonFormat(pattern = "dd/MM/yyyy")
    val dueDate: LocalDate,
) : Payment()

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonTypeName(value = "pix_issue")
data class PixRequest(
    @field: Valid
    override val payer: Payer,
    @field:[DecimalMin(value = "1.0")]
    val value: BigDecimal,
    @field: [NotEmpty Size(max = 50)]
    val pixKey: String,
    @field: [NotNull Valid]
    val receiver: IssueReciver,
    @JsonFormat(pattern = "dd/MM/yyyy")
    val dueDate: LocalDate
) : Payment()


data class IssueReciver(
    @field: [NotEmpty Size(max = 50)]
    val name: String,
    @field: NotEmpty
    val document: String
)
