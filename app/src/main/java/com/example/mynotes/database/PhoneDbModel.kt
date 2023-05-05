package com.example.mynotes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhoneDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "phone_number") val phoneNumber: String,
    @ColumnInfo(name = "tag") val tag: String,
    // @ColumnInfo(name = "can_be_checked_off") val canBeCheckedOff: Boolean,
    // @ColumnInfo(name = "is_checked_off") val isCheckedOff: Boolean,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "in_trash") val isInTrash: Boolean
) {
    companion object {
        val DEFAULT_PHONES = listOf(
            PhoneDbModel(1, "Pongsakorn", "0635989954", "Home", 1, false),
            PhoneDbModel(2, "Thanapat", "0823123312", "Work", 2, false)
            // PhoneDbModel(1, "RW Meeting", "Prepare sample project", false, false, 1, false),
            // PhoneDbModel(2, "Bills", "Pay by tomorrow", false, false, 2, false),
            // PhoneDbModel(3, "Pancake recipe", "Milk, eggs, salt, flour...", false, false, 3, false),
            // PhoneDbModel(4, "Workout", "Running, push ups, pull ups, squats...", false, false, 4, false),
            // PhoneDbModel(5, "Title 5", "Content 5", false, false, 5, false),
            // PhoneDbModel(6, "Title 6", "Content 6", false, false, 6, false),
            // PhoneDbModel(7, "Title 7", "Content 7", false, false, 7, false),
            // PhoneDbModel(8, "Title 8", "Content 8", false, false, 8, false),
            // PhoneDbModel(9, "Title 9", "Content 9", false, false, 9, false),
            // PhoneDbModel(10, "Title 10", "Content 10", false, false, 10, false),
            // PhoneDbModel(11, "Title 11", "Content 11", true, false, 11, false),
            // PhoneDbModel(12, "Title 12", "Content 12", true, false, 12, false)
        )
    }
}
