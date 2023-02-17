package com.tb.test.ui.list

import androidx.paging.AsyncPagingDataDiffer
import androidx.paging.PagingConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListUpdateCallback
import com.tb.test.domain.model.WorldWonder
import com.tb.test.domain.usecase.GetWonderPageData
import com.tb.test.ui.list.paging.WorldWonderPagerProviderImpl
import com.tb.test.ui.list.viewholder.WorldWonderViewHolder
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class WorldWonderListViewModelTest {

    @MockK
    lateinit var useCase: GetWonderPageData

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testItemLoading() = runTest {
        coEvery { useCase.invoke(any(), any()) }.coAnswers {
            listOf(newWorldWonder(1), newWorldWonder(2), newWorldWonder(3))
        }
        val expected = listOf(newContent(1), newContent(2), newContent(3))
        val target = WorldWonderListViewModel(
            pageProvider = WorldWonderPagerProviderImpl(useCase),
            PagingConfig(3, 0)
        )

        val differ = AsyncPagingDataDiffer(
            diffCallback = TestDiffCallback(),
            updateCallback = NoopListCallback(),
            workerDispatcher = StandardTestDispatcher(this.testScheduler)
        )
        val data = target.items.first()
        val job = launch {
            differ.submitData(data)
        }
        advanceUntilIdle()
        val pagingData = differ.snapshot().items
        assertEquals(expected, pagingData)
        job.cancel()
    }


    private fun newWorldWonder(id: Long): WorldWonder {
        val text = "test$id"
        return WorldWonder(id, text, text, text, text)
    }

    private fun newContent(id: Long): WorldWonderViewHolder.Content {
        val text = "test$id"
        return WorldWonderViewHolder.Content(id, text, text, text, text) {}
    }

    private fun assertEquals(
        e: WorldWonderViewHolder.Content,
        r: WorldWonderViewHolder.Content
    ) {
        assertEquals(e.id, r.id)
        assertEquals(e.title, r.title)
        assertEquals(e.content, r.content)
        assertEquals(e.imageUrl, r.imageUrl)
        assertEquals(e.location, r.location)
    }

    private fun assertEquals(
        e: List<WorldWonderViewHolder.Content>,
        r: List<WorldWonderViewHolder.Content>
    ) {
        if (e.size != r.size) Assert.fail()
        e.forEachIndexed { index, content ->
            assertEquals(content, r[index])
        }
    }

    class TestDiffCallback : DiffUtil.ItemCallback<WorldWonderViewHolder.Content>() {
        override fun areItemsTheSame(
            oldItem: WorldWonderViewHolder.Content,
            newItem: WorldWonderViewHolder.Content
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: WorldWonderViewHolder.Content,
            newItem: WorldWonderViewHolder.Content
        ): Boolean {
            return oldItem == newItem
        }
    }

    class NoopListCallback : ListUpdateCallback {
        override fun onChanged(position: Int, count: Int, payload: Any?) {}
        override fun onMoved(fromPosition: Int, toPosition: Int) {}
        override fun onInserted(position: Int, count: Int) {}
        override fun onRemoved(position: Int, count: Int) {}
    }

}