package com.example.mockito

interface SuspendRepo {
    suspend fun invoke(): Record
}

data class Record(
    private val name: String,
    private val name1: String,
    private val name2: String,
    private val name3: String,
    private val location: Location
)

data class Location(
    private val name: String,
    private val name1: String,
    private val name2: String,
    private val name3: String
)