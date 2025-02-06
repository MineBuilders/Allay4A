package vip.cdms.allay4a.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ServerViewModel : ViewModel() {
    var consoleText: MutableLiveData<String> = MutableLiveData<String>().apply {
        this.value += "111"
    }
}
