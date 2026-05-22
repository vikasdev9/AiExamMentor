package com.example.alexammentor.presentation.scan

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor() : ViewModel() {

    private val _extractedText = MutableStateFlow("")
    val extractedText = _extractedText.asStateFlow()

    private val _isProcessing = MutableStateFlow(false)
    val isProcessing = _isProcessing.asStateFlow()

    fun onTextDetected(text: String) {
        if (!_isProcessing.value) {
            _extractedText.value = text
        }
    }

    fun startProcessing() {
        _isProcessing.value = true
    }

    fun stopProcessing() {
        _isProcessing.value = false
    }
}
