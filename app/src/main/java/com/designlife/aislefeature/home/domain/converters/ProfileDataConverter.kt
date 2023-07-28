package com.designlife.aislefeature.home.domain.converters

import com.designlife.aislefeature.home.data.jdo.ProfileDataResponse
import com.designlife.aislefeature.home.data.jdo.Profiles
import com.designlife.aislefeature.home.domain.entities.ProfileData

object ProfileDataConverter {

    private fun getAvatar(photos: List<Profiles.Photos>): String? {
        photos.forEach {
             if (it.status.equals("avatar"))
                 return it.photo
        }
        return null
    }

    fun convertProfileData(profileData : ProfileDataResponse) : ProfileData?{

        val notesList = mutableListOf<ProfileData.TopNotes>()
        val likedProfiles = mutableListOf<ProfileData.LikedProfile>()
        profileData.invites?.let {invites ->
            invites.profiles?.forEach {profile ->
                profile.general_information?.let {generalInfoItem ->
                    profile.photos?.let {photoList ->
                        val avatar = getAvatar(photoList)
                        notesList.add(ProfileData.TopNotes(
                            firstName = generalInfoItem.first_name,
                            age = generalInfoItem.age,
                            avatar = avatar
                        ))
                    }
                }
            }
        }
        profileData.likes?.let {likes ->
            likes.profiles.forEach {recommendedProfile ->
                recommendedProfile.first_name?.let {firstName ->
                    recommendedProfile.avatar?.let {avatar ->
                        likedProfiles.add(ProfileData.LikedProfile(firstName,avatar))
                    }
                }
            }
        }
        return ProfileData(notesList,likedProfiles)
    }

}