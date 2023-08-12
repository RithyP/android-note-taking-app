package com.feature.authentication.data.repository

import com.core.common.UiEvent
import com.feature.authentication.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl : AuthRepository {
    private val firebaseAuth = FirebaseAuth.getInstance()
    override suspend fun login(email: String, password: String): UiEvent<FirebaseUser> {
        return try {
            val res = firebaseAuth.signInWithEmailAndPassword(
                email, password
            ).await()

            if (res.user != null) {
                UiEvent.Success(res.user)
            } else {
                UiEvent.Error(data = res.user)
            }

        } catch (e: Exception) {
            e.printStackTrace()
            UiEvent.Error(e.message.toString())
        }

    }

    override suspend fun logout(): UiEvent<Nothing> {
        return try {
            firebaseAuth.signOut()
            UiEvent.Success(null)
        } catch (e: Exception) {
            UiEvent.Error(e.message.toString(), null)
        }
    }
}
