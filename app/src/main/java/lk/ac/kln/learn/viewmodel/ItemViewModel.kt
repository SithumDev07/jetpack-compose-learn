package lk.ac.kln.learn.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import lk.ac.kln.learn.model.Item
import lk.ac.kln.learn.repository.ItemRepository
import javax.inject.Inject

interface ItemViewModelAbstract {

    val itemListFlow: Flow<List<Item>>

    fun addItem(item: Item)

}

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel(), ItemViewModelAbstract {

    private val ioScope = CoroutineScope(Dispatchers.IO)

    override val itemListFlow: Flow<List<Item>> = itemRepository.getAllFlow()

    override fun addItem(item: Item) {
        ioScope.launch {
            itemRepository.insertItems(item)
        }
    }

}