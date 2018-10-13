package co.ghostnotes.sample.viewmodeltest.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _count = MutableLiveData<Int>()
    val count
        get() = _count

    init {
        _count.value = 0
    }

    fun increment() {
        _count.value = _count.value!!.plus(1)
    }

}
