package com.lateinitvar.feedback.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lateinitvar.feedback.business.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _onEvent = MutableLiveData<OnLoginEvent>()

    val onEvent: LiveData<OnLoginEvent>
        get() = _onEvent

    fun getCurrentUser() = viewModelScope.launch {
        runCatching {
            loginUseCase.currentUser
        }.onSuccess {
            _onEvent.postValue(OnLoginEvent.IsLoggedIn)
        }.onFailure {
            // Not logged in. Do not do anything. User will have to log in.
        }
    }

    fun login(email: String?, password: String?) = viewModelScope.launch {
        when {
            email.isNullOrEmpty() -> _onEvent.postValue(OnLoginEvent.EmailIsNullOrEmpty)
            password.isNullOrEmpty() -> _onEvent.postValue(OnLoginEvent.PasswordIsNullOrEmpty)
            else -> {
                runCatching {
                    loginUseCase.signInWithEmailAndPassword(email, password)
                }.onSuccess {
                    _onEvent.postValue(OnLoginEvent.Success)
                }.onFailure {
                    _onEvent.postValue(OnLoginEvent.Error)
                }
            }
        }
    }

    sealed class OnLoginEvent {
        object IsLoggedIn : OnLoginEvent()
        object Success : OnLoginEvent()
        object Error: OnLoginEvent()
        object EmailIsNullOrEmpty: OnLoginEvent()
        object PasswordIsNullOrEmpty: OnLoginEvent()
    }
}
