package com.mayur.robottoysim

import com.mayur.robottoysim.model.Direction
import com.mayur.robottoysim.model.Position
import com.mayur.robottoysim.model.Robot
import com.mayur.robottoysim.model.Table
import org.junit.Assert.assertEquals
import org.junit.Test

class RobotTest {

    @Test
    fun testMoveRobotNorth() {
        val robot = Robot(Direction.NORTH, Position(2, 2))
        val table = Table(4, 4)
        val newRobot = robot.move(table)
        assertEquals(Position(2, 3), newRobot?.position)
    }

    @Test
    fun testMoveRobotEast() {
        val robot = Robot(Direction.EAST, Position(2, 2))
        val table = Table(4, 4)
        val newRobot = robot.move(table)
        assertEquals(Position(3, 2), newRobot?.position)
    }

    @Test
    fun testMoveRobotSouth() {
        val robot = Robot(Direction.SOUTH, Position(2, 2))
        val table = Table(4, 4)
        val newRobot = robot.move(table)
        assertEquals(Position(2, 1), newRobot?.position)
    }

    @Test
    fun testMoveRobotWest() {
        val robot = Robot(Direction.WEST, Position(2, 2))
        val table = Table(4, 4)
        val newRobot = robot.move(table)
        assertEquals(Position(1, 2), newRobot?.position)
    }

    @Test
    fun testRobotTurnRight() {
        val robot = Robot(Direction.NORTH, Position(2, 2))
        val newRobot = robot.right()
        assertEquals(Direction.EAST, newRobot.facing)
    }

    @Test
    fun testRobotTurnLeft() {
        val robot = Robot(Direction.NORTH, Position(2, 2))
        val newRobot = robot.left()
        assertEquals(Direction.WEST, newRobot.facing)
    }

    @Test
    fun testRobotReport() {
        val robot = Robot(Direction.NORTH, Position(2, 2))
        val report = robot.report()
        assertEquals("2,2,NORTH", report)
    }

    @Test
    fun testRobotDoesNotMoveOutOfBounds() {
        val robot = Robot(Direction.NORTH, Position(3, 4))
        val table = Table(4, 4)

        robot.move(table) // Attempt to move NORTH, but it's out of bounds

        assertEquals(Position(3, 4), robot.position)
    }

    @Test
    fun testRobotTurnsInCircle() {
        val robot = Robot(Direction.NORTH, Position(2, 2))

        robot.right()     // Turn RIGHT, now facing EAST
        robot.right()     // Turn RIGHT, now facing SOUTH
        robot.right()     // Turn RIGHT, now facing WEST
        robot.right()     // Turn RIGHT, back to facing NORTH

        assertEquals(Direction.NORTH, robot.facing)
    }

    @Test
    fun testRobotReportsCorrectly() {
        val robot = Robot(Direction.SOUTH, Position(1, 3))

        val report = robot.report()

        assertEquals("1,3,SOUTH", report)
    }

    @Test
    fun testMoveRobotMultipleTimes() {
        val robot = Robot(Direction.NORTH, Position(2, 2))
        val table = Table(4, 4)

        // Initial position: (2, 2), facing: NORTH
        val robot1 = robot.move(table) // Move NORTH, new position (2, 3), facing: NORTH
        assertEquals(Position(2, 3), robot1?.position)
        assertEquals(Direction.NORTH, robot1?.facing)

        val robot2 = robot1?.right() // Turn RIGHT, now facing EAST
        assertEquals(Position(2, 3), robot2?.position)
        assertEquals(Direction.EAST, robot2?.facing)

        val robot3 = robot2?.move(table) // Move EAST, new position (3, 3), facing: EAST
        assertEquals(Position(3, 3), robot3?.position)
        assertEquals(Direction.EAST, robot3?.facing)

        val robot4 = robot3?.right() // Turn RIGHT, now facing SOUTH
        assertEquals(Position(3, 3), robot4?.position)
        assertEquals(Direction.SOUTH, robot4?.facing)

        val robot5 = robot4?.move(table) // Move SOUTH, new position (3, 2), facing: SOUTH
        assertEquals(Position(3, 2), robot5?.position)
        assertEquals(Direction.SOUTH, robot5?.facing)
    }

}
