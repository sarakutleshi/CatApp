package com.example.catapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catapp.api.RetrofitInstance
import com.example.catapp.models.CatImage
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {
    private val _catImages = MutableLiveData<List<CatImage>>()
    val catImages: LiveData<List<CatImage>> get() = _catImages

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun loadCatImages() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.apiService.getCatImages()
                if (response.isSuccessful) {
                    _catImages.value = response.body()
                }
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
}