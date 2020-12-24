package com.lateinitvar.feedback.di

import com.lateinitvar.feedback.business.api.FirebaseProvider
import com.lateinitvar.feedback.business.datasource.FeatureRemoteDataSource
import com.lateinitvar.feedback.business.datasource.LoginRemoteDataSource
import com.lateinitvar.feedback.business.repository.FeatureRepository
import com.lateinitvar.feedback.business.repository.LoginRepository
import com.lateinitvar.feedback.business.usecase.FeatureUseCase
import com.lateinitvar.feedback.business.usecase.LoginUseCase
import com.lateinitvar.feedback.ui.features.SuggestedFeaturesViewModel
import com.lateinitvar.feedback.ui.login.LoginViewModel
import com.lateinitvar.feedback.ui.signup.SignUpViewModel

class AppContainer {
    val firebaseProvider = FirebaseProvider()
    var signUpContainer: SignUpContainer? = null
    var loginContainer: LoginContainer? = null
    var featureContainer: FeaturesContainer? = null
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

class FeaturesContainer(firebaseProvider: FirebaseProvider) {
    private val featureRemoteDataSource = FeatureRemoteDataSource(firebaseProvider)
    private val featureRepository = FeatureRepository(featureRemoteDataSource)
    private val featureUseCase = FeatureUseCase(featureRepository)
    val featuresViewModel = SuggestedFeaturesViewModel(featureUseCase)
}