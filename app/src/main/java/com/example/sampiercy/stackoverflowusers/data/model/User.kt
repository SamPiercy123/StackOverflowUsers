package com.example.sampiercy.stackoverflowusers.data.model

import android.os.Parcel
import android.os.Parcelable

data class User(
        val reputation: Int,
        val creationDate: Int,
        val userId: Int,
        val location: String,
        val profileImage: String,
        val displayName: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(reputation)
        parcel.writeInt(creationDate)
        parcel.writeInt(userId)
        parcel.writeString(location)
        parcel.writeString(profileImage)
        parcel.writeString(displayName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}