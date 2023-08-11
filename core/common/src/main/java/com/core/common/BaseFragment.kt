package com.core.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!


    /* override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         _binding = viewBindingInflater(layoutInflater)
         binding = _binding
         setContentView(binding.root)
         setStatusBarTransparent()

         initView()
         initObserver()
         initAction()
     }*/

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
}