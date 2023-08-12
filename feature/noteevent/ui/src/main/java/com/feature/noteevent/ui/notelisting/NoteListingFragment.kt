package com.feature.noteevent.ui.notelisting

import com.core.common.BaseFragment
import com.feature.noteevent.ui.databinding.FragmentNoteListingBinding

class NoteListingFragment :
    BaseFragment<FragmentNoteListingBinding>(FragmentNoteListingBinding::inflate) {

    override fun initView() {
        // TODO add view later
    }

    override fun initAction() {
        binding.addNoteBtn.setOnClickListener {

        }
    }
}