package com.santander.prueba.repository.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "meet_ups", schema = "public")
data class MeetupModel(
        val attendees: Long,
        val description: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    fun toDomain(): Meetup {
        return Meetup(id, attendees, description)
    }
}