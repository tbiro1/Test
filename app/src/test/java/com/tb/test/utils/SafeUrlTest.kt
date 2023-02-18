package com.tb.test.utils

import com.tb.test.utils.url.SafeUrl
import org.junit.Assert.assertEquals
import org.junit.Test

abstract class SafeUrlTest {

    abstract fun getInstance(): SafeUrl

    @Test
    fun testAgainstBrokenUrl() {
        val testData = "http://test.com//test/////////"
        val expected = "https://test.com/test/"

        val target = getInstance()

        val result = target.makeUrlSafe(testData)
        assertEquals(expected, result)
    }

    @Test
    fun testValidUrl() {
        val testData = "https://test.com/valid_url"

        val target = getInstance()

        val result = target.makeUrlSafe(testData)
        assertEquals(testData, result)
    }

}