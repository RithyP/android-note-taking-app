package com.feature.noteevent.ui.notelisting

import androidx.fragment.app.viewModels
import com.core.common.BaseFragment
import com.core.common.extension.collectLatestOnStart
import com.feature.noteevent.ui.databinding.FragmentNoteListingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListingFragment :
    BaseFragment<FragmentNoteListingBinding>(FragmentNoteListingBinding::inflate) {

    private val noteListViewModel: NoteListingViewModel by viewModels()

    override fun initView() {
        // TODO add view later
    }

    override fun initAction() {
        binding.addNoteBtn.setOnClickListener {

        }
    }

    override fun initObserver() {
        noteListViewModel.noteEventList.collectLatestOnStart(viewLifecycleOwner) { res ->
            handleOnRes(res) { resData ->

            }
        }
    }
}