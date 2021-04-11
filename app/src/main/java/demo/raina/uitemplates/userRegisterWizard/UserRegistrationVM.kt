package demo.raina.uitemplates.userRegisterWizard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * [ViewModel] to handle New User Registration with the required attribute(s) and event(s).
 */
class UserRegistrationVM : ViewModel() {

    //Accepted terms.
    val _checked = MutableLiveData(false)

    // Personal input details.
    val _name = MutableLiveData<String>()
    val _mobile = MutableLiveData<String>()
    val _email = MutableLiveData<String>()

    // ID Proof input details.
    val _panNumber = MutableLiveData<String>()
    val _uidaiNumber = MutableLiveData<String>()

    fun registerNewUser() {

    }
}