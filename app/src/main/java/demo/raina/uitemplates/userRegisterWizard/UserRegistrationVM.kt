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

    //Error Messages.
    val _errName = MutableLiveData<String>()
    val _errMobile = MutableLiveData<String>()
    val _errEmail = MutableLiveData<String>()
    val _errPanNumber = MutableLiveData<String>()
    val _errUidai = MutableLiveData<String>()

    fun registerNewUser() {

    }
}