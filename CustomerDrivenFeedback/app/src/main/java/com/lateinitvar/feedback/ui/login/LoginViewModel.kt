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

    private val _onEvent = MutableLiveData<String>()

    val onEvent: LiveData<String>
        get() = _onEvent

    fun login(email: String?, password: String?) = viewModelScope.launch {
        when {
            email.isNullOrEmpty() -> ""
            password.isNullOrEmpty() -> ""
            else -> {
                runCatching {
                    loginUseCase.signInWithEmailAndPassword(email, password)
                }.onSuccess {

                }.onFailure {

                }
            }
        }
    }
}
