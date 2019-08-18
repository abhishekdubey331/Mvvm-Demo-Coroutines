package com.demo.demomeow.utils

import okhttp3.ResponseBody
import org.json.JSONObject

object Constants {

    const val NUMBER_OF_CATS = 20
    const val CAT_API_BASE_URL = "https://api.thecatapi.com/v1/"
    const val SERVER_DOWN_ERROR = "Server is down"
    const val SERVER_DOWN_CODE = -1
    const val NUMBER_OF_COLUMNS = 3

    fun getErrorMessage(response: ResponseBody?): String {
        val errorObj = JSONObject(response?.string())
        return errorObj.getString("message")
    }
}