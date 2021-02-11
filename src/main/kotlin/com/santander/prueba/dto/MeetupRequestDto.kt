package com.santander.prueba.dto

import org.springframework.format.annotation.DateTimeFormat
import java.util.Date

data class MeetupRequestDto(
    val id: Long?,
    val description: String,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val date: Date
)
