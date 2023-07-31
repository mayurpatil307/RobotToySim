package com.mayur.robottoysim.model

data class Table(val width: Int = 5, val height: Int = 5) {

    fun withinBoundaries(position: Position) = position.x in 0..width && position.y in 0..height

}

