package jp.yn.android.light.reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import jp.co.yahoo.android.repository.item.ItemEntityRepository
import jp.yn.android.light.reader.databinding.ItemContentFragmentBinding

class ItemContentFragment : Fragment() {

    private lateinit var viewModel: ItemContentViewModel
    private lateinit var binding: ItemContentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.item_content_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val item = arguments?.let {
            ItemContentFragmentArgs.fromBundle(it).item
        } ?: throw NullPointerException("arguments is null")

        viewModel = ViewModelProviders
            .of(this, ItemContentViewModel.Factory(ItemEntityRepository(item)))
            .get(ItemContentViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.onCreate()
    }
}