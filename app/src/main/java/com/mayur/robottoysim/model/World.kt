package com.mayur.robottoysim.model

import java.util.logging.Logger

class World constructor(private val table: Table = Table()) {

    private val logger = Logger.getLogger(World::class.java.name)

    private val size = 5

    private var robot: Robot? = null

    private var field = Array(size) { IntArray(size) }

    fun report(): String? {
        return this.robot?.report()
    }

    fun place(facing: Direction, position: Position) {
        logger.info("placing robot $facing, $position")
        this.robot = Robot(facing, position)
    }

    fun place(position: Position) {
        logger.info("placing object at $position")
        this.field[position.x][position.y] = 1
    }

    fun right() {
        logger.info("turning right")
        this.robot = this.robot?.right()
    }

    fun left() {
        logger.info("turning left")
        this.robot = this.robot?.left()
    }

    fun moveRobot() {
        this.robot = this.robot?.move(table)
    }

    fun field(): Array<IntArray> {
        return this.field
    }

}
