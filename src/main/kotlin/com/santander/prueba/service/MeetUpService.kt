package com.santander.prueba.service

import com.santander.prueba.domain.MeetUp
import com.santander.prueba.domain.Registration
import com.santander.prueba.mapper.MeetUpMapper
import com.santander.prueba.mapper.RegistrationMapper
import com.santander.prueba.repository.MeetupRepository
import com.santander.prueba.repository.RegistrationRepository
import org.springframework.stereotype.Service

@Service
class MeetUpService(
    private val meetUpRepository: MeetupRepository,
    private val mapper: MeetUpMapper,
    private val registrationMapper: RegistrationMapper,
    private val registrationRepository: RegistrationRepository
) {

    fun createMeetUp(meetUp: MeetUp): MeetUp {
        return mapper.toDomain(meetUpRepository.save(mapper.toModel(meetUp)))
    }

    fun listMeetUps(): List<MeetUp> {
        return meetUpRepository.findAll().map { mapper.toDomain(it) }
    }

    fun getMeetUp(id: Long): MeetUp {
        return mapper.toDomain(meetUpRepository.getOne(id))
    }

    fun createRegistration(id: Long, registration: Registration): Registration {

        return registrationMapper.toDomain(registrationRepository.save(registrationMapper.toModel(registration)))
    }
}

/*
    Hacer funcion en service que cree una registration
    Hacer llamado del controller al service
    y usar los mappers
 */