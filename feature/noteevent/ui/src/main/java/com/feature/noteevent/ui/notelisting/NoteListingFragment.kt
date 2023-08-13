package com.feature.noteevent.ui.notelisting

import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.core.common.base.BaseFragment
import com.core.common.extension.collectLatestOnStart
import com.core.common.extension.customNavigateFragment
import com.feature.noteevent.domain.model.NoteEvent
import com.feature.noteevent.ui.R
import com.feature.noteevent.ui.databinding.FragmentNoteListingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListingFragment :
    BaseFragment<FragmentNoteListingBinding>(FragmentNoteListingBinding::inflate) {

    private val noteListViewModel: NoteListingViewModel by viewModels()

    private val noteAdapter by lazy {
        NoteListingItem { item ->
            navigateToDetailScreen(item)
        }
    }

    override fun initView() {
        binding.noteList.adapter = noteAdapter
    }

    override fun initAction() {
        binding.addNoteBtn.setOnClickListener {
            navigateToDetailScreen()
        }
    }

    override fun initObserver() {
        noteListViewModel.noteEventList.collectLatestOnStart(viewLifecycleOwner) { res ->
            handleOnRes(res) { resData ->
                if (resData.isNotEmpty()) {
                    noteAdapter.setData(resData)
                    binding.emptyPlaceHolder.isVisible = false
                } else {
                    binding.emptyPlaceHolder.isVisible = true
                }
            }
        }
    }

    private fun navigateToDetailScreen(noteData: NoteEvent? = null) {
        findNavController().customNavigateFragment(
            R.id.noteDetailFragment,
            bundleOf("noteDetail" to noteData),
        )
    }
}