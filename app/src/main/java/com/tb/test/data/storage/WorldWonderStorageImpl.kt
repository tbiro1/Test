package com.tb.test.data.storage

import android.content.res.AssetManager
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.tb.test.data.entity.WorldWonderEntity
import com.tb.test.di.qualifier.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Read all data at first call then respond from in memory cache.
 * Possible refactor: Use streamed reading or cache data in LocalDB (Room or Realm).
 */
class WorldWonderStorageImpl @Inject constructor(
    private val assetManager: AssetManager,
    private val gson: Gson,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : WorldWonderStorage {

    private val cacheMutex = Mutex(false)
    private var cache: List<WorldWonderEntity>? = null

    override suspend fun getWonders(offset: Int, size: Int): List<WorldWonderEntity> {
        return withContext(ioDispatcher) {
            ensureCache().subList(offset, offset + size)
        }
    }

    /**
     * Loads cache if necessary.
     */
    private suspend fun ensureCache(): List<WorldWonderEntity> {
        return cacheMutex.withLock {
            val cache = this.cache
            cache ?: gson.fromJson<WorldWonderList>(
                JsonReader(
                    assetManager.open("real.planet.world-heritage.json").reader()
                ), WorldWonderList::class.java
            ).also {
                this.cache = it
            }
        }
    }

}

/**
 * Helper class to read Array to generic list.
 */
private class WorldWonderList : ArrayList<WorldWonderEntity>()