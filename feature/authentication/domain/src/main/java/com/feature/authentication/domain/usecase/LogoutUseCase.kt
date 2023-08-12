package com.feature.authentication.domain.usecase

import com.core.common.UiEvent
import com.feature.authentication.domain.repository.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): UiEvent<Nothing> {
        return authRepository.logout()
    }
}