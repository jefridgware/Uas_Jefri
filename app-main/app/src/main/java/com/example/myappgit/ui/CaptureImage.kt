package com.example.myappgit.ui

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

data class CaptureImage(
    val bitmap: Bitmap?,
    val description: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Bitmap::class.java.classLoader),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(bitmap, flags)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CaptureImage> {
        override fun createFromParcel(parcel: Parcel): CaptureImage {
            return CaptureImage(parcel)
        }

        override fun newArray(size: Int): Array<CaptureImage?> {
            return arrayOfNulls(size)
        }
    }
}
