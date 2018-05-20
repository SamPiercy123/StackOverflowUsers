package com.example.sampiercy.stackoverflowusers

import com.example.sampiercy.stackoverflowusers.data.model.User
import com.example.sampiercy.stackoverflowusers.data.model.UsersResponse
import java.util.*

const val REPUTATION_BASE = 31821093
const val CREATION_BASE = 1222430705
const val USER_ID_BASE = 230183374
const val LOCATION_BASE = "London"
const val PROFILE_IMAGE_BASE = "http://dskandasl.asdlkna"
const val DISPLAY_NAME_BASE = "George Eldridge"


fun createUserResponse(numUsers: Int): UsersResponse {

    var usersResponse = UsersResponse(LinkedList())

    repeat(numUsers, {
        val reputation = REPUTATION_BASE + it
        val creationDate = CREATION_BASE + it * 86400 //increment by one day
        val userID = USER_ID_BASE + it * 56
        val location = LOCATION_BASE + it
        val profileImage = PROFILE_IMAGE_BASE + it
        val displayName = DISPLAY_NAME_BASE + it

        val user = User(reputation, creationDate, userID, location, profileImage, displayName)

        usersResponse.items.add(user)
    })

    return usersResponse
}