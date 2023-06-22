package com.jptest.realogyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jptest.realogyapp.model.Characters
import com.jptest.realogyapp.network.CharacterRepository
import com.jptest.realogyapp.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {
    private val _character = MutableLiveData<Response<Characters>>()
    val character: LiveData<Response<Characters>>
        get() = _character

    init {
        fetchSat()
    }

    fun fetchSat() {
        _character.postValue((Response.Loading()))
        viewModelScope.launch {
            try {
                _character.postValue((Response.Success(repository.getCharacters())))
            } catch (e: Exception) {
                _character.postValue((e.message?.let { Response.Error(it) }))
            }
        }
    }

}