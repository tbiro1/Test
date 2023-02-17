package com.tb.test.domain.usecase

import com.tb.test.data.storage.WorldWonderStorage
import com.tb.test.domain.mapper.WorldWonderMapper
import com.tb.test.domain.model.WorldWonder
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetWonderPageDataImpl @Inject constructor(
    private val worldWonderStorage: WorldWonderStorage,
    private val worldWonderMapper: WorldWonderMapper
) : GetWonderPageData {
    override suspend fun invoke(offset: Int, limit: Int): List<WorldWonder> {
        delay(1000) //emulate latency
        return worldWonderStorage.getWonders(offset, limit)
            .map { entity -> worldWonderMapper.mapFromEntity(entity) }

    }
}