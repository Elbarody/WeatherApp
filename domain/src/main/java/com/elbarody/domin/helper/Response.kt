package com.elbarody.domin.helper

sealed interface Response<out T> {
    class Success<T>(val data: T): Response<T>
    class Error<T>(val errorMessage: String): Response<T>
}