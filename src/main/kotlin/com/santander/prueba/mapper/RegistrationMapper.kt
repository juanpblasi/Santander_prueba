package com.santander.prueba.mapper


import com.santander.prueba.domain.Registration
import com.santander.prueba.dto.RegistrationDto
import com.santander.prueba.dto.RegistrationRequestDto
import com.santander.prueba.repository.model.RegistrationModel
import org.springframework.stereotype.Component

@Component
class RegistrationMapper {

    fun toDomain(registrationRequestDto: RegistrationRequestDto): Registration {
        return Registration(registrationRequestDto.id, registrationRequestDto.personName)
    }

    fun toDomain(registrationModel: RegistrationModel): Registration {
        return Registration(registrationModel.id, registrationModel.personName)
    }

    fun toModel(registration: Registration): RegistrationModel {
        return RegistrationModel(registration.personName)
    }

    fun toDto(registration: Registration): RegistrationDto {
        return RegistrationDto(registration.id!!, registration.personName)
    }
}