package demo.raina.uitemplates.userRegisterWizard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * [ViewModel] to handle New User Registration with the required attribute(s) and event(s).
 */
class UserRegistrationVM : ViewModel() {

    private val _name = MutableLiveData<String>()
    private val _mobile = MutableLiveData<String>()
    private val _email = MutableLiveData<String>()
    private val _panNumber = MutableLiveData<String>()
    private val _uidaiNumber = MutableLiveData<String>()

    fun registerNewUser() {
        
    }
}