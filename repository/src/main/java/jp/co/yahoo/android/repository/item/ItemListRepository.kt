package jp.co.yahoo.android.repository.item

import jp.co.yahoo.android.api.RetrofitCreator
import jp.co.yahoo.android.api.UrlConstant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ItemListRepository {
    private var itemService = RetrofitCreator(UrlConstant.API_V2, ItemService::class.java)

    fun getItemList(
        page: Int = 1,
        perPage: Int = 10,
        onSuccess: (List<ItemEntity>) -> Unit,
        onFailure: (Throwable?) -> Unit
    ) {
        itemService.items(page, perPage).enqueue(object : Callback<List<ItemEntity>> {
            override fun onResponse(
                call: Call<List<ItemEntity>>?,
                response: Response<List<ItemEntity>>?
            ) {
                val body = response?.body()
                if (body == null) {
                    Timber.d("responseBody is null")
                    onFailure(null)
                    return
                }
                if (!response.isSuccessful) {
                    Timber.d("response.isSuccessful == false")
                    onFailure(null)
                    return
                }
                onSuccess(body)
            }

            override fun onFailure(call: Call<List<ItemEntity>>?, t: Throwable?) {
                Timber.e(t)
                onFailure(t)
            }
        })
    }
}