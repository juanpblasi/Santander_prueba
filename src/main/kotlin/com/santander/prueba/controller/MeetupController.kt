package com.santander.prueba.controller

import com.santander.prueba.dto.RegistrationRequestDto
import com.santander.prueba.dto.MeetUpDto
import com.santander.prueba.dto.MeetupRequestDto
import com.santander.prueba.dto.RegistrationDto
import com.santander.prueba.mapper.MeetUpMapper
import com.santander.prueba.service.MeetUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("meet-ups")
class MeetupController(private val service: MeetUpService, private val mapper: MeetUpMapper) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    fun createMeetup(@RequestBody meetupRequest: MeetupRequestDto): MeetUpDto {
        return mapper.toDto(service.createMeetUp(mapper.toDomain(meetupRequest)))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK) // 200
    fun listMeetups(): List<MeetUpDto> {
        return service.listMeetUps().map { mapper.toDto(it) }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200
    fun getMeetup(@PathVariable id: Long): MeetUpDto {
        return mapper.toDto(service.getMeetUp(id))
    }

    @PostMapping("/{id}/registrations")
    @ResponseStatus(HttpStatus.CREATED) // 201
    fun createRegistration(
        @PathVariable id: Long,
        @RequestBody registrationRequestDto: RegistrationRequestDto
    ): RegistrationDto {
        return registrationMapper.toDto(
            service.createRegistration(
                id,
                registrationMapper.toDomain(registrationRequestDto)
            )
        )
    }
}
