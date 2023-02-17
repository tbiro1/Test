package com.tb.test.data.storage

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class WorldWonderStorageTest {


    @Test
    fun testReadFirst10Element() = runTest {
        val instance = WorldWonderStorageImpl(
            InstrumentationRegistry.getInstrumentation().context.assets,
            Gson(),
            StandardTestDispatcher(this.testScheduler)
        )
        val wonders = instance.getWonders(0, 10)
        assertEquals(10, wonders.size)
        val expectedIds = listOf<Int>(
            3, 2, 1, 29, 26, 4, 27, 24, 18, 18
        )
        assertEquals(expectedIds, wonders.map { it.id.toInt() })
    }

    @Test
    fun testReadOutsideOfItems() = runTest {
        val instance = WorldWonderStorageImpl(
            InstrumentationRegistry.getInstrumentation().context.assets,
            Gson(),
            StandardTestDispatcher(this.testScheduler)
        )
        val wonders = instance.getWonders(10, 10)
        assertEquals(0, wonders.size)
    }

    @Test
    fun testReadNothing() = runTest {
        val instance = WorldWonderStorageImpl(
            InstrumentationRegistry.getInstrumentation().context.assets,
            Gson(),
            StandardTestDispatcher(this.testScheduler)
        )
        val wonders = instance.getWonders(0, 0)
        assertEquals(0, wonders.size)
    }

}