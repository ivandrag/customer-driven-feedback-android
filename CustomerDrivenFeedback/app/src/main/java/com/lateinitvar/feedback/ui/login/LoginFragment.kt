package com.lateinitvar.feedback.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sign_up_text_view.setOnClickListener {
            findNavController().navigate(R.id.start_sign_up_fragment)
        }

        loginViewModel.onEvent.observe(viewLifecycleOwner, {
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.loginContainer = null
    }
}
