package com.santander.prueba.repository.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "meet_ups", schema = "public")
data class MeetupModel(
    var description: String,
    var date: Date,
    @OneToMany(mappedBy = "meetUp", fetch = FetchType.LAZY)
    @JsonManagedReference
    var registrations: List<RegistrationModel> = listOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column("meet_up_id")
    var id: Long = 0
}
