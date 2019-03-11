package pl.org.seva.myapplication.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel : ViewModel() {
    val liveInt by lazy { MutableLiveData<Int>() }
}
