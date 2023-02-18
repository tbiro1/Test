package com.tb.test.domain.usecase

import com.tb.test.data.storage.WorldWonderStorage
import com.tb.test.domain.mapper.WorldWonderMapper
import com.tb.test.domain.mapper.WorldWonderMapperImpl
import com.tb.test.testutils.generator.newWorldWonder
import com.tb.test.testutils.generator.newWorldWonderEntity
import com.tb.test.utils.url.SafeUrlImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetWonderPageDataTest {

    @MockK
    lateinit var storage: WorldWonderStorage
    private val mapper: WorldWonderMapper = WorldWonderMapperImpl(SafeUrlImpl())

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher(TestScope().testScheduler))
    }

    @Test
    fun `test when offset is 0 and loading size is same the item count return the all item`() =
        runTest {
            coEvery { storage.getWonders(any(), any()) }.coAnswers {
                listOf(
                    newWorldWonderEntity(1),
                    newWorldWonderEntity(2),
                    newWorldWonderEntity(3)
                )
            }
            val expected = listOf(newWorldWonder(1), newWorldWonder(2), newWorldWonder(3))
            val useCase = GetWonderPageDataImpl(storage, mapper)


            val result = useCase.invoke(0, 3)
            assertEquals(expected, result)
        }
}