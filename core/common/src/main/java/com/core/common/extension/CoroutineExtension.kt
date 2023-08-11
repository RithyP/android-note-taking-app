package com.core.common.extension


import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//TODO: Replace launchWhenStarted with repeatOnLifeCycle and retest again.

fun Fragment.launchWhenStarted(block: suspend CoroutineScope.() -> Unit) {
    viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        block()
    }
}

fun Fragment.launchWhenCreated(block: suspend CoroutineScope.() -> Unit) {
    viewLifecycleOwner.lifecycleScope.launchWhenCreated {
        block()
    }
}

/**
 * The value of this stateflow won't be called if the collection is null or empty so please be aware of this
 */
inline fun <reified T> Flow<T?>.collectLatestOnStart(
    owner: LifecycleOwner, crossinline action: suspend (value: T) -> Unit
) {
    owner.lifecycleScope.launchWhenStarted {
        collectLatest { item ->
            if (T::class == Collection::class) {
                if ((item as Collection<*>?).isNullOrEmpty()) return@collectLatest
            }
            if (item == null) return@collectLatest

            action(item)
        }
    }
}

inline fun <reified T> Flow<T?>.collectWhenCreate(
    owner: LifecycleOwner, crossinline action: suspend (value: T) -> Unit
) {
    owner.lifecycleScope.launchWhenCreated {
        collect { item ->
            if (T::class == Collection::class) {
                if ((item as Collection<*>?).isNullOrEmpty()) return@collect
            }
            if (item == null) return@collect

            action(item)
        }
    }
}

suspend fun <T> MutableStateFlow<T?>.set(value: T, idle: T? = null, delay: Long = 100) {
    this.value = value
    delay(delay)
    this.value = idle
}

fun ViewModel.launchInViewModel(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch {
        block()
    }
}