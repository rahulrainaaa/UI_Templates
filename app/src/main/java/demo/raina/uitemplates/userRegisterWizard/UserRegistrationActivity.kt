package demo.raina.uitemplates.userRegisterWizard

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import demo.raina.uitemplates.R
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
        binding.includeLayout.btnFragmentNavigation.setOnClickListener { btnFragmentNavigationClick() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.terms_accept_fragment -> {
                    binding.toolbar.title = getString(R.string.terms)
                    binding.includeLayout.btnFragmentNavigation.text = getString(R.string.accepted)
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                }
                R.id.personal_detail_fragment -> {
                    binding.toolbar.title = getString(R.string.personal_detail)
                    binding.includeLayout.btnFragmentNavigation.text = getString(R.string.save_details)
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
                R.id.user_id_proof_fragment -> {
                    binding.toolbar.title = getString(R.string.id_proof)
                    binding.includeLayout.btnFragmentNavigation.text = getString(R.string.verify_id)
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }
        }
    }

    private fun btnFragmentNavigationClick() {

        val navController = findNavController(R.id.nav_host_fragment)
        when (navController.currentDestination?.id) {
            R.id.terms_accept_fragment -> {
                if (userRegistrationVM._checked.value == true)
                    navController.navigate(R.id.terms_accept_to_personal_detail_fragment)
                else
                    Toast.makeText(this, R.string.accept_the_terms, Toast.LENGTH_SHORT).show()
            }
            R.id.personal_detail_fragment -> {
                var isPersonalDataValidInput = true
                if (userRegistrationVM._name.value.isNullOrBlank()) {
                    isPersonalDataValidInput = false
                    userRegistrationVM._errName.postValue(getString(R.string.cannot_be_blank))
                } else {
                    userRegistrationVM._errName.postValue(null)
                }

                if (userRegistrationVM._mobile.value.isNullOrBlank() || userRegistrationVM._mobile.value?.trim()?.length != 10) {
                    isPersonalDataValidInput = false
                    userRegistrationVM._errMobile.postValue(getString(R.string.enter_mobile_number))
                } else {
                    userRegistrationVM._errMobile.postValue(null)
                }

                if (userRegistrationVM._email.value.isNullOrBlank()) {
                    isPersonalDataValidInput = false
                    userRegistrationVM._errEmail.postValue(getString(R.string.email_required))
                } else {
                    userRegistrationVM._errEmail.postValue(null)
                }

                if (isPersonalDataValidInput) navController.navigate(R.id.personal_detail_to_id_proof_fragment)
            }
            R.id.user_id_proof_fragment -> {
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                findNavController(R.id.nav_host_fragment).popBackStack()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}