package com.feature.authentication.domain.repository

import com.core.common.UiEvent
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String): UiEvent<FirebaseUser>

    suspend fun logout(): UiEvent<Nothing>
}