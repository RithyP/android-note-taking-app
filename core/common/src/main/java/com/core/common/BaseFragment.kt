package com.core.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        initAction()
    }

    /**
     * Use for controlling view property or attribute.
     */
    open fun initView() {}

    /**
     * Use this for populating actionable view like on button clicked, on text changed, etc...
     */
    open fun initAction() {}

    /**
     * Use this function only for state observing like listening to LiveData or Coroutine Flow.
     */
    open fun initObserver() {}

    /**
     * Use when the data has already been decrypted only
     */
    protected open fun <T> handleOnRes(
        respond: UiEvent<T>,
        showLoading: Boolean = true,
        onSuccess: (T) -> Unit = {},
    ) {
        when (respond) {
            is UiEvent.Loading -> {
//                if (showLoading) showLoading()
            }

            is UiEvent.Success -> {
                onSuccess(respond.data!!)
            }

            is UiEvent.Error -> {
                Toast.makeText(requireContext(), "${respond.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}