package com.feature.authentication.ui.login

import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.core.common.base.BaseFragment
import com.core.common.extension.collectLatestOnStart
import com.core.common.extension.customNavigateFragment
import com.feature.authentication.ui.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun initView() {
        super.initView()
    }

    override fun initAction() {
        binding.loginBtn.setOnClickListener {
            loginViewModel.userLogin(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }

    override fun initObserver() {
        loginViewModel.loginUser.collectLatestOnStart(viewLifecycleOwner) {
            handleOnRes(it) {
                Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                findNavController().customNavigateFragment("myApp://noteListingFragment")
            }
        }
    }
}