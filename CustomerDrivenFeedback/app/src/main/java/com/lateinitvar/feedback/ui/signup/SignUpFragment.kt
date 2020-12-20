package com.lateinitvar.feedback.ui.signup

import android.os.Bundle
import android.view.View
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.SignUpContainer
import com.lateinitvar.feedback.ui.BaseFragment

class SignUpFragment: BaseFragment(R.layout.fragment_sign_up) {

    private lateinit var signUpViewModel: SignUpViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signUpContainer = SignUpContainer(appContainer.firebaseProvider)
        signUpViewModel = signUpContainer.signUpViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.signUpContainer = null
    }
}
