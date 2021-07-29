package de.kubisflo.validatingforminput

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class PersonForm(
    @field:NotNull @field:Size(min=2, max=30) val name: String?,
    @field:NotNull @field:Min(18) val age: Int?
)
