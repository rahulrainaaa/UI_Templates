package demo.raina.uitemplates.userRegisterWizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import demo.raina.uitemplates.databinding.FragTermsAcceptBinding

class TermsAcceptFragment : Fragment() {

    private lateinit var binding: FragTermsAcceptBinding
    private lateinit var userRegistrationVM: UserRegistrationVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragTermsAcceptBinding.inflate(inflater, container, false)
        userRegistrationVM = ViewModelProvider(requireActivity()).get(UserRegistrationVM::class.java)
        binding.vm = userRegistrationVM
        return binding.root
    }

}
