package com.feature.authentication.domain.usecase

import com.core.common.UiEvent
import com.feature.authentication.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): UiEvent<FirebaseUser> {
        return authRepository.login(email, password)
    }
}