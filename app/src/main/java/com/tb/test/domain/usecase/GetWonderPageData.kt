package com.tb.test.domain.usecase

import com.tb.test.domain.model.WorldWonder

/**
 * Data source for pagination
 */
interface GetWonderPageData : suspend (Int, Int) -> List<WorldWonder>