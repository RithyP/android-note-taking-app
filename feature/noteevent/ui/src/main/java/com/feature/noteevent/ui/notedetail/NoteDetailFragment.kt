package com.feature.noteevent.ui.notedetail

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.core.common.base.BaseFragment
import com.core.common.util.DateTimeFormatter
import com.feature.noteevent.ui.databinding.FragmentNoteDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class NoteDetailFragment :
    BaseFragment<FragmentNoteDetailBinding>(FragmentNoteDetailBinding::inflate) {

    private val args: NoteDetailFragmentArgs by navArgs()
    private val noteDetailViewModel: NoteDetailViewModel by viewModels()

    override fun initView() {
        if (noteDetailViewModel.noteDetail.value == null) {
            binding.titleEditText.setText(args.noteDetail?.title)

            binding.descriptionEditText.setText(args.noteDetail?.description)
        }
    }

    override fun initAction() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.dateAndTimeEditText.setOnClickListener {
            pickDateTime { cal ->
                onDatePick(cal)
            }
        }
    }

    private fun pickDateTime(onDateTimePickAction: (Calendar) -> Unit) {
        val currentDateTime = Calendar.getInstance()
        val startYear = currentDateTime.get(Calendar.YEAR)
        val startMonth = currentDateTime.get(Calendar.MONTH)
        val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)
        val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = currentDateTime.get(Calendar.MINUTE)

        DatePickerDialog(requireContext(), { _, year, month, day ->
            TimePickerDialog(requireContext(), { _, hour, minute ->
                val pickedDateTime = Calendar.getInstance()
                pickedDateTime.set(year, month, day, hour, minute)
                onDateTimePickAction(pickedDateTime)
            }, startHour, startMinute, false).show()
        }, startYear, startMonth, startDay).show()
    }

    private fun onDatePick(cal: Calendar) {
        val dateTimeDisplay = DateTimeFormatter.convertCalendarToString(cal)
        binding.dateAndTimeEditText.setText(dateTimeDisplay)
    }
}