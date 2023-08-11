package com.feature.authentication.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.authentication.domain.usecase.LoginUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loginUser = MutableStateFlow<UiEvent<FirebaseUser>?>(null)
    val loginUser = _loginUser.asStateFlow()

    fun userLogin(email: String, password: String) {
        viewModelScope.launch {
            _loginUser.value = UiEvent.Loading()
            _loginUser.value = loginUseCase.invoke(email, password)
        }
    }


}