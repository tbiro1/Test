package com.tb.test.ui.list

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.tb.test.R
import com.tb.test.databinding.FragmentWorldWoderListBinding
import com.tb.test.ui.list.adapter.WorldWonderAdapter
import com.tb.test.ui.list.adapter.WorldWonderLoadStateAdapter
import com.tb.test.utils.binding.bindings
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WorldWonderListFragment : Fragment(R.layout.fragment_world_woder_list) {

    private val binding: FragmentWorldWoderListBinding by bindings()
    private val viewModel: WorldWonderListViewModel by viewModels()
    private val adapter = WorldWonderAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setup UI here
        binding.recyclerView.adapter =
            adapter.withLoadStateFooter(WorldWonderLoadStateAdapter(adapter::retry))
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.items.collectLatest {
                    adapter.submitData(it)
                }
            }
        }
        adapter.addOnPagesUpdatedListener(this::onPageUpdate)

    }

    private fun onPageUpdate() {
        binding.progress.isGone = true
        adapter.removeOnPagesUpdatedListener(this::onPageUpdate)
    }

}