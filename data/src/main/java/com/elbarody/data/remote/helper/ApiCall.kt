package com.elbarody.data.remote.helper

import com.elbarody.domin.helper.Response
import java.io.IOException

/**
 * A generic function for making API calls with error handling.
 *
 * This function is designed to be used with suspending API calls. It wraps the API call
 * with try-catch blocks to handle exceptions and provides a uniform way of dealing with responses.
 *
 * @param call A suspending lambda function representing the API call.
 * @return A sealed class [Response] containing either the success data or an error message.
 */
suspend inline fun <T> apiCall(crossinline call: suspend () -> T): Response<T> {
    return try {
        Response.Success(data = call())
    } catch (e: IOException) {
        Response.Error(errorMessage = "Check your internet connection")
    } catch (e: Exception) {
        Response.Error(
            errorMessage = e.message
                ?: "Error occurred, Please try again later"
        )
    }
}