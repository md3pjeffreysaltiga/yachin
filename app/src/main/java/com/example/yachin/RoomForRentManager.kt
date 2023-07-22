package com.example.yachin

data class RoomForRent(
    val owner: String,
    val rentPrice: Double,
    val address: String,
    val facebookAccount: String,
    val contactNumber: String
)

class RoomForRentManager {
    companion object {
        val roomList: MutableList<RoomForRent> = mutableListOf()
    }

    fun addRoom(room: RoomForRent) {
        roomList.add(room)
    }

    fun removeRoom(room: RoomForRent) {
        roomList.remove(room)
    }
}
