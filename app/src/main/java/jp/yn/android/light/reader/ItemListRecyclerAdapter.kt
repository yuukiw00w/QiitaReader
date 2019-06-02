package jp.yn.android.light.reader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import jp.co.yahoo.android.repository.item.ItemEntity
import jp.yn.android.light.reader.databinding.ItemEntityBinding

class ItemListRecyclerAdapter(private val onClickListener: (View, ItemEntity) -> Unit) :
    RecyclerView.Adapter<ItemListRecyclerAdapter.ViewHolder>() {
    private var items: List<ItemEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemEntityBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_entity,
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.itemEntity = item
        holder.binding.itemEntityCard.setOnClickListener {
            onClickListener(it, item)
        }
    }

    override fun getItemCount() = items.size

    fun update(newItems: List<ItemEntity>) {
        items = newItems
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemEntityBinding) : RecyclerView.ViewHolder(binding.root)
}

@BindingAdapter("items")
fun RecyclerView.bindItems(items: List<ItemEntity>?) {
    if (items == null) {
        return
    }
    val adapter = adapter as ItemListRecyclerAdapter
    adapter.update(items)
}
