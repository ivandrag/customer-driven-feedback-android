package com.lateinitvar.feedback.ui.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.LoginContainer
import com.lateinitvar.feedback.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val loginViewModel: LoginViewModel by lazy {
        val loginContainer = LoginContainer(appContainer.firebaseProvider)
        loginContainer.loginViewModel
    }

    private val onLoginObserver = Observer<LoginViewModel.OnLoginEvent> {
        when(it) {
            is LoginViewModel.OnLoginEvent.Success -> findNavController().navigate(R.id.start_features_fragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sign_up_text_view.setOnClickListener {
            findNavController().navigate(R.id.start_sign_up_fragment)
        }

        login_button.setOnClickListener {
            loginViewModel.login(email_edit_text.text.toString(), password_edit_text.text.toString())
        }
        registerObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.loginContainer = null
    }

    private fun registerObservers() {
        loginViewModel.onEvent.observe(viewLifecycleOwner, onLoginObserver)
    }
}
