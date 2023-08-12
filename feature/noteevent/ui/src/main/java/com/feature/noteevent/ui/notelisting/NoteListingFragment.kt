package com.feature.noteevent.ui.notelisting

import androidx.fragment.app.viewModels
import com.core.common.base.BaseFragment
import com.core.common.extension.collectLatestOnStart
import com.feature.noteevent.ui.databinding.FragmentNoteListingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListingFragment :
    BaseFragment<FragmentNoteListingBinding>(FragmentNoteListingBinding::inflate) {

    private val noteListViewModel: NoteListingViewModel by viewModels()

    private val noteAdapter by lazy {
        NoteListingItem { item ->

        }
    }

    override fun initView() {
        binding.noteList.adapter = noteAdapter
    }

    override fun initAction() {
        binding.addNoteBtn.setOnClickListener {

        }
    }

    override fun initObserver() {
        noteListViewModel.noteEventList.collectLatestOnStart(viewLifecycleOwner) { res ->
            handleOnRes(res) { resData ->
                noteAdapter.setData(resData)
            }
        }
    }
}