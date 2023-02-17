package com.tb.test.domain.usecase

import com.tb.test.data.storage.WorldWonderStorage
import com.tb.test.domain.mapper.WorldWonderMapper
import com.tb.test.domain.model.WorldWonder
import javax.inject.Inject

class GetWonderPageDataImpl @Inject constructor(
    private val worldWonderStorage: WorldWonderStorage,
    private val worldWonderMapper: WorldWonderMapper
) : GetWonderPageData {
    override suspend fun invoke(offset: Int, limit: Int): List<WorldWonder> {
        return worldWonderStorage.getWonders(offset, limit)
            .map { entity -> worldWonderMapper.mapFromEntity(entity) }
    }
}