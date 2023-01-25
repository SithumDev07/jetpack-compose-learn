package lk.ac.kln.learn.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) var itemId: Long? = null,
    val text: String
)