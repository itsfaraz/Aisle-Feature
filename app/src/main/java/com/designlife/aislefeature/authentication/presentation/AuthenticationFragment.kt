package com.designlife.aislefeature.authentication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.designlife.aislefeature.R
import com.designlife.aislefeature.authentication.presentation.components.AuthComponent
import com.designlife.aislefeature.authentication.presentation.viewmodel.AuthenticationViewModel
import com.designlife.aislefeature.authentication.presentation.viewmodel.AuthenticationViewModelFactory
import com.designlife.aislefeature.common.utils.AppServiceLocator
import com.designlife.aislefeature.common.presentation.components.CustomProgressBar
import com.designlife.aislefeature.common.utils.Constants

class AuthenticationFragment : Fragment() {

    private lateinit var viewmodel : AuthenticationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val authenticationRepository = AppServiceLocator.provideAuthenticationRepository(requireActivity().application)
        val factory = AuthenticationViewModelFactory(authenticationRepository)
        viewmodel = ViewModelProvider(this,factory)[AuthenticationViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val isLogin = viewmodel.isLogin.value
                    val userNumber = viewmodel.userNumber.value
                    val countryCode = viewmodel.countryCode.value
                    val otpNumber = viewmodel.otpNumber.value
                    val countDown = viewmodel.countDown.value
                    val progressBar = viewmodel.progressBar.value
                    val isUserVerified = viewmodel.isUserVerified.value
                    val buttonVisibility = viewmodel.buttonVisibility.value
                    val token = viewmodel.token.value
                    Box(modifier = Modifier.fillMaxSize().alpha(if(progressBar) 0.4f else 1F)) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Spacer(modifier = Modifier.height(80.dp))
                            AuthComponent(
                                isLogin = isLogin,
                                userNumber = userNumber,
                                countryCode = countryCode,
                                onEditEvent = { if (!isLogin){
                                    viewmodel.onEvent(AuthenticationEvents.OnEditEvent)
                                } },
                                onCountryCodeEvent = { viewmodel.onEvent(AuthenticationEvents.OnCountryCodeChange(it))},
                                inputText = otpNumber,
                                onInputChange = {
                                    viewmodel.onEvent(AuthenticationEvents.OnInputChange(it))
                                },
                                countDownText = "00:"+if(countDown.toInt() < 10) "0$countDown" else countDown,
                                buttonVisibility = buttonVisibility,
                                onContinueEvent = {
                                    viewmodel.onEvent(AuthenticationEvents.OnContinueEvent)
                                }
                            )

                        }
                        if (progressBar){
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CustomProgressBar()
                            }
                        }

                    }

                    if (isUserVerified){
                        val bundle = bundleOf()
                        bundle.putString(Constants.TOKEN,token)
                        findNavController().navigate(
                            resId = R.id.homeFragment,
                            args = bundle
                        )
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewmodel.resetAuth()
    }
}