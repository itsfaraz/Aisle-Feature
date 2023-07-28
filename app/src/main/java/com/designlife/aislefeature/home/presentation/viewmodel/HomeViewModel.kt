package com.designlife.aislefeature.home.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.designlife.aislefeature.home.domain.converters.ProfileDataConverter
import com.designlife.aislefeature.home.domain.entities.ProfileData
import com.designlife.aislefeature.home.domain.repository.NotesRepository
import com.designlife.aislefeature.home.presentation.HomeEvents
import com.designlife.aislefeature.home.presentation.helper.ScreenType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val notesRepository : NotesRepository
) : ViewModel() {

    private val _selectedScreenItemType : MutableState<ScreenType> = mutableStateOf(ScreenType.NOTES)
    val selectedScreenItemType = _selectedScreenItemType

    private val _token : MutableState<String> = mutableStateOf("")
    val token = _token

    private val _progressBar : MutableState<Boolean> = mutableStateOf(false)
    val progressBar = _progressBar

    private val _topNotes : MutableState<List<ProfileData.TopNotes>> = mutableStateOf(listOf())
    val topNotes = _topNotes

    private val _likedProfiles : MutableState<List<List<ProfileData.LikedProfile>>> = mutableStateOf(listOf())
    val likedProfiles = _likedProfiles

    fun onEvent(event : HomeEvents){
        when(event){
            is HomeEvents.OnItemSelected -> {
                _selectedScreenItemType.value = event.screenType
            }
            is HomeEvents.OnTokenUpdate -> {
                _token.value = event.token
            }
        }
    }

    fun initiateDataRequest() {
        _progressBar.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val response = notesRepository.profileData(_token.value)
            response?.let {
                val convertedData = ProfileDataConverter.convertProfileData(it)
                convertedData.let {
                    if (it != null){
                        _topNotes.value = it.topNotes
                        _likedProfiles.value = getConstructedList(it.profiles)
                    }
                }
            }
            _progressBar.value = false
        }
    }

    fun getConstructedList(likedProfiles: List<ProfileData.LikedProfile>): List<List<ProfileData.LikedProfile>> {
        val pairList = ArrayList<List<ProfileData.LikedProfile>>()
        val tempList = mutableListOf<ProfileData.LikedProfile>()
        likedProfiles.forEachIndexed { index, likedProfile ->
            tempList.add(likedProfile)
            if (index != 0 && index%2 != 0){
                pairList.add(ArrayList(tempList))
                tempList.clear()
            }
        }
        return pairList
    }

}