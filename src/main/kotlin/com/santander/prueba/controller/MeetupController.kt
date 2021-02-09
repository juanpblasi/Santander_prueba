package com.santander.prueba.controller

import com.santander.prueba.domain.Meetup
import com.santander.prueba.dto.MeetupRequestDto
import com.santander.prueba.repository.MeetupRepository
import com.santander.prueba.repository.model.MeetupModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("meet-ups")
class MeetupController(private val repository: MeetupRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createMeetup(@RequestBody meetup: MeetupRequestDto): String {
        val newMeetup = MeetupModel(meetup.attendees,meetup.description)
        repository.save(newMeetup)
        return "Meetup Guardada"
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listMeetups(): List<Meetup> {
        return repository.findAll().map { it.toDomain() }
    }


}