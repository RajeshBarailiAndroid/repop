package com.jptest.realogyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jptest.realogyapp.model.Characters
import com.jptest.realogyapp.model.RelatedTopics
import com.jptest.realogyapp.utils.Response
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    private val _details = MutableLiveData<RelatedTopics>()
    val details: LiveData<RelatedTopics>
        get() = _details
    fun set(current: RelatedTopics) {
    _details.value=current
    }
}