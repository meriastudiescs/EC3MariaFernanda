package com.example.evaluacioncontinua03.ui.fragments.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluacioncontinua03.data.FactServiceResult
import com.example.evaluacioncontinua03.data.repository.FactRepository
import com.example.evaluacioncontinua03.model.Fact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FactListViewModel: ViewModel() {
    private val _facts : MutableLiveData<List<Fact>> = MutableLiveData<List<Fact>>()
    val facts: LiveData<List<Fact>> = _facts

    private val repository = FactRepository()

    fun getFactsFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getFacts()
            when (response) {
                is FactServiceResult.Success -> {
                    _facts.postValue(response.data.facts)
                }
                is FactServiceResult.Error -> {
                    //Pasar un error a otro lado
                }
            }
        }
    }

}