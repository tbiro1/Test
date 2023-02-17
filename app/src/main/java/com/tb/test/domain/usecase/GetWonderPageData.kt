package com.tb.test.domain.usecase

import com.tb.test.domain.model.WorldWonder

interface GetWonderPageData : suspend (Int, Int) -> List<WorldWonder>