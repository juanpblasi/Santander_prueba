package com.santander.prueba.repository.model

import com.santander.prueba.domain.Meetup
import javax.persistence.*

@Entity
@Table(name = "meet_ups",schema = "public")
data class MeetupModel (
    val attendees: Long,
    val description: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    fun toDomain(): Meetup{
        return Meetup(id,attendees,description)
    }
}