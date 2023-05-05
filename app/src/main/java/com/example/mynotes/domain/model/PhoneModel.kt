package com.example.mynotes.domain.model

const val NEW_PHONE_ID = -1L

data class PhoneModel(
    val id: Long = NEW_PHONE_ID, // This value is used for new phones
    val title: String = "",
    val phoneNumber: String = "",
    val tag: String = "",
//    val isCheckedOff: Boolean? = null, // null represents that the phone can't be checked off
    val color: ColorModel = ColorModel.DEFAULT
)