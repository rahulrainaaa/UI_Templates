package demo.raina.uitemplates

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import demo.raina.uitemplates.databinding.ActivityMainBinding
import demo.raina.uitemplates.userRegisterWizard.UserRegistrationActivity

/**
 * [AppCompatActivity] class to show list of options on main screen which are to be demonstrated within this application.
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.includeContent.btnUserRegisterWizard.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_user_register_wizard -> startActivity(Intent(this, UserRegistrationActivity::class.java))
            else -> Toast.makeText(this, "Unhandled Click", Toast.LENGTH_SHORT).show()
        }
    }

}