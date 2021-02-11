package com.santander.prueba.controller

import com.santander.prueba.dto.RegistrationRequestDto
import com.santander.prueba.dto.MeetUpDto
import com.santander.prueba.dto.MeetupRequestDto
import com.santander.prueba.mapper.MeetUpMapper
import com.santander.prueba.service.MeetUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("meet-ups")
class MeetupController(private val service: MeetUpService, private val mapper: MeetUpMapper) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createMeetup(@RequestBody meetupRequest: MeetupRequestDto): MeetUpDto {
        return mapper.toDto(service.createMeetUp(mapper.toDomain(meetupRequest)))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listMeetups(): List<MeetUpDto> {
        return service.listMeetUps().map { mapper.toDto(it) }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getMeetup(@PathVariable id: Long): MeetUpDto {
        return mapper.toDto(service.getMeetUp(id))
    }
}
