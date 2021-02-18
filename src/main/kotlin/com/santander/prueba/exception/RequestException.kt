package com.santander.prueba.exception

class RequestException(
    override var message: String,
    var code: String,
    var status: Int
) : RuntimeException()
