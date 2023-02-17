package com.tb.test.data.storage

import com.tb.test.data.entity.WorldWonderEntity

/**
 * This storage is responsible for reading the world wonders from a persistent storage.
 */
interface WorldWonderStorage {

    /**
     * Reads wonder entities with limit logic. If the required offset and size exceed the size of the wonders
     * it can return with less element than size.
     * If there is no wonders or offset is higher than wonders size it return an empty list.
     *
     * @param offset the position of the first wonder
     * @param size the size of the wonders in the result.
     */
    suspend fun getWonders(offset: Int, size: Int) : List<WorldWonderEntity>
}