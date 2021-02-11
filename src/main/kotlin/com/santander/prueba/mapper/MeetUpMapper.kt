package com.santander.prueba.mapper

import com.santander.prueba.domain.MeetUp
import com.santander.prueba.dto.MeetUpDto
import com.santander.prueba.dto.MeetupRequestDto
import com.santander.prueba.repository.model.MeetupModel
import org.springframework.stereotype.Component

@Component
class MeetUpMapper {

    fun toDomain(meetUpRequest: MeetupRequestDto): MeetUp {
        return MeetUp(meetUpRequest.id, meetUpRequest.description, meetUpRequest.date)
    }

    fun toDomain(meetUpModel: MeetupModel): MeetUp {
        return MeetUp(meetUpModel.id, meetUpModel.description, meetUpModel.date)
    }

    fun toModel(meetUp: MeetUp): MeetupModel {
        return MeetupModel(meetUp.description, meetUp.date)
    }

    fun toDto(meetUp: MeetUp): MeetUpDto {
        return MeetUpDto(meetUp.id, meetUp.description, meetUp.date)
    }
}
