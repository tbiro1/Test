package com.tb.test.domain.mapper

import com.tb.test.utils.url.SafeUrlImpl

class WorldWonderMapperTestImpl : WorldWonderMapperTest() {
    override fun getInstance(): WorldWonderMapper {
        return WorldWonderMapperImpl(SafeUrlImpl())
    }
}