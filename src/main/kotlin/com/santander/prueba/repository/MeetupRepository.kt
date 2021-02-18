package com.santander.prueba.repository

import com.santander.prueba.repository.model.MeetupModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MeetupRepository : JpaRepository<MeetupModel, Long>