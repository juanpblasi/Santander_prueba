package com.santander.prueba.controller

import com.santander.prueba.domain.Meetup
import com.santander.prueba.dto.MeetupRequestDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("meet-ups")
class MeetupController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createMeetup(@RequestBody meetup: MeetupRequestDto): Meetup {
      return Meetup(1,0,meetup.description)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getMeetup(): Meetup {
        return Meetup(1,0,"asd")
    }

}