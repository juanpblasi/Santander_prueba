package com.santander.prueba.service

import com.santander.prueba.domain.MeetUp
import com.santander.prueba.mapper.MeetUpMapper
import com.santander.prueba.repository.MeetupRepository
import org.springframework.stereotype.Service

@Service
class MeetUpService(private val meetUpRepository: MeetupRepository, private val mapper: MeetUpMapper) {

    fun createMeetUp(meetUp: MeetUp): MeetUp {
        return mapper.toDomain(meetUpRepository.save(mapper.toModel(meetUp)))
    }

    fun listMeetUps(): List<MeetUp> {
        return meetUpRepository.findAll().map { mapper.toDomain(it) }
    }

    fun getMeetUp(id: Long): MeetUp {
        return mapper.toDomain(meetUpRepository.getOne(id))
    }
}
