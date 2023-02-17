package com.tb.test.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tb.test.R
import com.tb.test.databinding.FragmentWorldWoderListBinding
import com.tb.test.utils.binding.bindings

class WorldWonderListFragment : Fragment(R.layout.fragment_world_woder_list) {

    private val binding: FragmentWorldWoderListBinding by bindings()
    private val viewModel: WorldWonderListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setup UI here
    }

}