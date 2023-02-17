package com.tb.test.domain.mapper

import com.tb.test.data.entity.WorldWonderEntity
import com.tb.test.domain.model.WorldWonder
import com.tb.test.domain.model.WorldWonderDetails

interface WorldWonderMapper {
    fun mapFromEntity(entity: WorldWonderEntity) : WorldWonder
    fun mapDetailsFromEntity(entity: WorldWonderEntity) : WorldWonderDetails
}