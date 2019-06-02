package jp.yn.android.light.reader

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jp.co.yahoo.android.repository.item.ItemEntity
import jp.co.yahoo.android.repository.item.ItemListRepository

class ItemListViewModel(private val repository: ItemListRepository) : ViewModel() {
    val items = MutableLiveData<List<ItemEntity>?>()

    fun onCreate() {
        repository.getItemList(page = 1, perPage = 10, onSuccess = { newItems ->
            items.postValue(newItems)
        }, onFailure = {
            // failure
        })
    }

    class Factory(private val repository: ItemListRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return ItemListViewModel(repository) as T
        }
    }
}