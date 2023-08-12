package com.feature.authentication.domain.usecase

import com.core.common.UiEvent
import com.core.common.util.validator.EmailValidator
import com.core.common.util.validator.PasswordValidator
import com.feature.authentication.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): UiEvent<FirebaseUser> {
        return if (!EmailValidator.isValidEmail(email)) {
            UiEvent.Error("Email is invalid.")
        } else if (!PasswordValidator.isPasswordValid(password)) {
            UiEvent.Error("Password is invalid.")
        } else {
            authRepository.login(email, password)
        }
    }
}