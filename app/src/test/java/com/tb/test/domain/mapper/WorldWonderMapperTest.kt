package com.tb.test.domain.mapper

import com.tb.test.data.entity.WorldWonderEntity
import com.tb.test.domain.model.WorldWonder
import org.junit.Assert.assertEquals
import org.junit.Test

abstract class WorldWonderMapperTest {

    abstract fun getInstance() : WorldWonderMapper

    @Test
    fun testMapping() {
        val expected = WorldWonder(1, "Test", "Test", "Test")
        val mockEntity = WorldWonderEntity(1, 1991,"Test","Test","Test","Test","Test","Test",0.0,0.0,"Test","Test","Test","Test","Test")

        val mapper = getInstance()

        assertEquals(expected, mapper.mapFromEntity(mockEntity))
    }

}