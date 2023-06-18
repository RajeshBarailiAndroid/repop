package com.jptest.realogyapp.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
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

    private fun fetchSat() {
        _character.postValue((Response.Loading()))
        viewModelScope.launch {
            try {
                _character.postValue((Response.Success(repository.getCharacters())))
                Log.e("--------------------------", "fetchSat: "+repository.getCharacters() )
            } catch (e: Exception) {
                Log.e(TAG, "fetchSat: "+repository.getCharacters().toString() )
                _character.postValue((e.message?.let { Response.Error(it) }))
            }
        }
    }

}