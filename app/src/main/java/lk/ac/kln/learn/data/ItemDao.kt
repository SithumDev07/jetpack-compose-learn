package lk.ac.kln.learn.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import lk.ac.kln.learn.model.Item

@Dao
interface ItemDao {

    @Query("select * from items")
    fun getAll(): Flow<List<Item>>

    @Insert
    suspend fun insert(item: Item)
}