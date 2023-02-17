package com.tb.test.domain.mapper

import com.tb.test.data.entity.WorldWonderEntity
import com.tb.test.domain.model.WorldWonder
import com.tb.test.domain.model.WorldWonderDetails
import com.tb.test.utils.url.SafeUrl
import javax.inject.Inject

class WorldWonderMapperImpl @Inject constructor(private val safeUrl: SafeUrl) :
    WorldWonderMapper {
    override fun mapFromEntity(entity: WorldWonderEntity): WorldWonder {
        return WorldWonder(
            id = entity.id,
            name = entity.name,
            shortInfo = entity.shortInfo,
            imageUrl = safeUrl.makeUrlSafe(entity.image)
        )
    }

    override fun mapDetailsFromEntity(entity: WorldWonderEntity): WorldWonderDetails {
        return WorldWonderDetails(
            id = entity.id,
            name = entity.name,
            longInfo = entity.longInfo ?: "",
            imageUrl = safeUrl.makeUrlSafe(entity.image),
            pageUrl = safeUrl.makeUrlSafe(entity.page),
            location = entity.regionLong
        )
    }

}