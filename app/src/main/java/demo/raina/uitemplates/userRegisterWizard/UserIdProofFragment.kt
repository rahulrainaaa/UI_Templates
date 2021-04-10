package demo.raina.uitemplates.userRegisterWizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import demo.raina.uitemplates.databinding.FragUserIdProofBinding

/**
 * [Fragment] class to handle UI for inputting User ID proofs for new user registration.
 */
class UserIdProofFragment : Fragment() {

    private lateinit var binding: FragUserIdProofBinding
    private lateinit var userRegistrationVM: UserRegistrationVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragUserIdProofBinding.inflate(inflater, container, false)
        userRegistrationVM = ViewModelProvider(requireActivity()).get(UserRegistrationVM::class.java)
        binding.vm = userRegistrationVM
        return binding.root
    }

}