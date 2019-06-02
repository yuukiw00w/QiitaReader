package jp.co.yahoo.android.repository.item

import android.os.Parcel
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.squareup.moshi.Json

data class ItemEntity(
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "body")
    val body: String
) : Parcelable, NavArgs {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(updatedAt)
        parcel.writeString(title)
        parcel.writeString(body)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ItemEntity> {
        override fun createFromParcel(parcel: Parcel): ItemEntity {
            return ItemEntity(parcel)
        }

        override fun newArray(size: Int): Array<ItemEntity?> {
            return arrayOfNulls(size)
        }
    }
}