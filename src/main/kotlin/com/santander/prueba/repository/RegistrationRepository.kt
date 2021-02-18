package com.santander.prueba.repository

import com.santander.prueba.repository.model.RegistrationModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RegistrationRepository : JpaRepository<RegistrationModel, Long>