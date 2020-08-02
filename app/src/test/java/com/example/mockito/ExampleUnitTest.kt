package com.example.mockito

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.core.IsEqual
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        //Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        //Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        //mainThreadSurrogate.close()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testNormalRepo() {
        val normalRepo = mock(NormalRepo::class.java)
        `when`(normalRepo.invoke()).thenReturn(10)
        assertThat(normalRepo.invoke(), IsEqual(10))
    }

    @Test
    fun testSuspendRepo() {
        runBlocking {
            val location = Location("asd", "asd", "asd", "asd")
            val record = Record("123","123","123","123", location)

            val locationAns = Location("asd", "asd", "asd", "asd")
            val recordAns = Record("123","123","123","123", locationAns)

            val suspendRepo = mock(SuspendRepo::class.java)
            `when`(suspendRepo.invoke()).thenReturn((record))
            assertThat(listOf(suspendRepo.invoke()).toTypedArray(), IsEqual(listOf(recordAns).toTypedArray()))
            //assertArrayEquals(listOf(record).toTypedArray(), listOf(recordAns).toTypedArray())
        }
    }
}