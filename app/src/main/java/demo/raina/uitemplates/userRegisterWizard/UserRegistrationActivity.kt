package demo.raina.uitemplates.userRegisterWizard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import demo.raina.uitemplates.databinding.ActivityUserRegistrationBinding

/**
 * [AppCompatActivity] class to handle UI for new user registration with following navigation of fragments.
 * 1. [PersonalDetailFragment] to input personal details.
 * 2. [UserIdProofFragment] to input Id Proofs and verification.
 */
class UserRegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserRegistrationBinding
    private lateinit var userRegistrationVM: UserRegistrationVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        userRegistrationVM = ViewModelProvider(this).get(UserRegistrationVM::class.java)
        binding.vm = userRegistrationVM
    }


}