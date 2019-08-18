package com.demo.demomeow.commons

class ServerException(val errorCode: Int,val errorMessage: String) : Exception(errorMessage)