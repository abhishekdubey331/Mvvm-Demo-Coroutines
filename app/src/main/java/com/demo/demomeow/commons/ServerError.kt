package com.demo.demomeow.commons

class ServerError(val errorCode: Int, val errorMessage: String) : Exception(errorMessage)