package com.lateinitvar.feedback.di

import com.lateinitvar.feedback.business.api.FirebaseProvider
import com.lateinitvar.feedback.business.datasource.LoginRemoteDataSource
import com.lateinitvar.feedback.business.repository.LoginRepository
import com.lateinitvar.feedback.business.usecase.LoginUseCase
import com.lateinitvar.feedback.ui.login.LoginViewModel
import com.lateinitvar.feedback.ui.signup.SignUpViewModel

class AppContainer {
    val firebaseProvider = FirebaseProvider()
    var signUpContainer : SignUpContainer? = null
    var loginContainer : LoginContainer? = null
}

class LoginContainer(firebaseProvider: FirebaseProvider) {
    private val loginRemoteDataSource = LoginRemoteDataSource(firebaseProvider)
    private val loginRepository = LoginRepository(loginRemoteDataSource)
    private val loginUseCase = LoginUseCase(loginRepository)
    val loginViewModel = LoginViewModel(loginUseCase)
}

class SignUpContainer(firebaseProvider: FirebaseProvider) {
    private val loginRemoteDataSource = LoginRemoteDataSource(firebaseProvider)
    private val loginRepository = LoginRepository(loginRemoteDataSource)
    private val loginUseCase = LoginUseCase(loginRepository)
    val signUpViewModel = SignUpViewModel(loginUseCase)
}
