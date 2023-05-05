package com.example.mynotes.database

import com.example.mynotes.domain.model.ColorModel
import com.example.mynotes.domain.model.NEW_PHONE_ID
import com.example.mynotes.domain.model.PhoneModel

class DbMapper {
    // Create list of PhoneModels by pairing each phone with a color
    fun mapPhones(
        phoneDbModels: List<PhoneDbModel>,
        colorDbModels: Map<Long, ColorDbModel>
    ): List<PhoneModel> = phoneDbModels.map {
        val colorDbModel = colorDbModels[it.colorId]
            ?: throw RuntimeException("Color for colorId: ${it.colorId} was not found. Make sure that all colors are passed to this method")

        mapPhone(it, colorDbModel)
    }

    // convert PhoneDbModel to PhoneModel
    fun mapPhone(phoneDbModel: PhoneDbModel, colorDbModel: ColorDbModel): PhoneModel {
        val color = mapColor(colorDbModel)
//        val isCheckedOff = with(phoneDbModel) { if (canBeCheckedOff) isCheckedOff else null }
        return with(phoneDbModel) { PhoneModel(id, title, phoneNumber, tag, color) }
    }

    // convert list of ColorDdModels to list of ColorModels
    fun mapColors(colorDbModels: List<ColorDbModel>): List<ColorModel> =
        colorDbModels.map { mapColor(it) }

    // convert ColorDbModel to ColorModel
    fun mapColor(colorDbModel: ColorDbModel): ColorModel =
        with(colorDbModel) { ColorModel(id, name, hex) }

    // convert PhoneModel back to PhoneDbModel
    fun mapDbPhone(phone: PhoneModel): PhoneDbModel =
        with(phone) {
//            val canBeCheckedOff = isCheckedOff != null
//            val isCheckedOff = isCheckedOff ?: false
            if (id == NEW_PHONE_ID)
                PhoneDbModel(
                    title = title,
                    phoneNumber = phoneNumber,
                    tag = tag,
//                     = content,
//                    canBeCheckedOff = canBeCheckedOff,
//                    isCheckedOff = isCheckedOff,
                    colorId = color.id,
                    isInTrash = false
                );
            else
                PhoneDbModel(id, title, phoneNumber, tag, color.id, false)
        }
}