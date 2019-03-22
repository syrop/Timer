package pl.org.seva.timer.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel : ViewModel() {
    val liveInt by lazy { MutableLiveData<Int>() }
}
