package lk.ac.kln.learn.repository

import kotlinx.coroutines.flow.Flow
import lk.ac.kln.learn.data.ItemDao
import lk.ac.kln.learn.model.Item

class ItemRepository(private val itemDao: ItemDao) {

    fun getAllFlow(): Flow<List<Item>> = itemDao.getAll()

    suspend fun insertItems(item: Item) = itemDao.insert(item)

}