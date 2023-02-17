package com.tb.test.utils

import com.tb.test.utils.url.SafeUrl
import org.junit.Assert.assertEquals
import org.junit.Test

abstract class SafeUrlTest {

    abstract fun getInstance(): SafeUrl

    @Test
    fun testUrlAgainstKnownErrors() {
        val testData = "http://test.com//test//with///////"
        val expected = "https://test.com/test/with/"

        val target = getInstance()

        val result = target.makeUrlSafe(testData)
        assertEquals(expected, result)
    }

}