package com.mayur.robottoysim.model

import java.util.logging.Logger

data class Robot(private val facing: Direction,
                 private val position: Position = Position()
) {

    private val logger = Logger.getLogger(Robot::class.java.name)

    fun move(table: Table): Robot? {
        val next = when (facing) {
            Direction.NORTH -> Robot(facing, position.north())
            Direction.EAST -> Robot(facing, position.east())
            Direction.WEST -> Robot(facing, position.west())
            Direction.SOUTH -> Robot(facing, position.south())
        }

        logger.info("next move: $next")
        return if (table.withinBoundaries(next.position)) next else this
    }

    fun right(): Robot = when (facing) {
        Direction.NORTH -> Robot(Direction.EAST, position)
        Direction.EAST -> Robot(Direction.SOUTH, position)
        Direction.SOUTH -> Robot(Direction.WEST, position)
        Direction.WEST -> Robot(Direction.NORTH, position)
    }

    fun left(): Robot = when (facing) {
        Direction.NORTH -> Robot(Direction.WEST, position)
        Direction.EAST -> Robot(Direction.NORTH, position)
        Direction.SOUTH -> Robot(Direction.EAST, position)
        Direction.WEST -> Robot(Direction.SOUTH, position)
    }

    fun report(): String = "$position,$facing"
}

