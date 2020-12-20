package com.lateinitvar.feedback.ui.signup

import android.os.Bundle
import android.view.View
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.SignUpContainer
import com.lateinitvar.feedback.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment: BaseFragment(R.layout.fragment_sign_up) {

    private val signUpViewModel: SignUpViewModel by lazy {
        val signUpContainer = SignUpContainer(appContainer.firebaseProvider)
        signUpContainer.signUpViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sign_up_button.setOnClickListener {
            signUpViewModel.signUp(email_edit_text.text.toString(), password_edit_text.text.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.signUpContainer = null
    }
}
