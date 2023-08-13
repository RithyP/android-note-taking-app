package com.feature.noteevent.ui.notelisting

import com.core.common.base.BaseAdapter
import com.feature.noteevent.domain.model.NoteEvent
import com.feature.noteevent.ui.databinding.LayoutNoteListItemBinding

class NoteListingItem(private val onItemClick: (NoteEvent) -> Unit) :
    BaseAdapter<LayoutNoteListItemBinding, NoteEvent>(LayoutNoteListItemBinding::inflate) {

    override fun onBind(holder: VH<LayoutNoteListItemBinding, NoteEvent>, item: NoteEvent) {
        holder.binding.apply {
            noteTitle.text = item.title
            noteTitle.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}