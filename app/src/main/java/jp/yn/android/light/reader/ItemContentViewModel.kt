package jp.yn.android.light.reader

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jp.co.yahoo.android.repository.item.ItemEntityRepository

class ItemContentViewModel(private val repository: ItemEntityRepository) : ViewModel() {
    val title = MutableLiveData<String>()
    val body = MutableLiveData<String>()

    fun onCreate() {
        title.postValue(repository.itemEntity.title)
        body.postValue(repository.itemEntity.body)
    }

    class Factory(private val repository: ItemEntityRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return ItemContentViewModel(repository) as T
        }
    }
}