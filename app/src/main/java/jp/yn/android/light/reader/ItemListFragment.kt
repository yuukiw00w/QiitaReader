package jp.yn.android.light.reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import jp.co.yahoo.android.repository.item.ItemListRepository
import jp.yn.android.light.reader.databinding.ItemListFragmentBinding

class ItemListFragment : Fragment() {

    private lateinit var viewModel: ItemListViewModel
    private lateinit var binding: ItemListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.item_list_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders
            .of(this, ItemListViewModel.Factory(ItemListRepository()))
            .get(ItemListViewModel::class.java)

        binding.viewModel = viewModel

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = ItemListRecyclerAdapter { view, itemEntity ->
            val action = ItemListFragmentDirections.actionListToContentFragment(itemEntity)
            view.findNavController().navigate(action)
        }
        binding.recyclerView.adapter = adapter

        viewModel.onCreate()
    }
}