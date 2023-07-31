package com.mayur.robottoysim

import com.mayur.robottoysim.model.Direction
import com.mayur.robottoysim.model.Position
import com.mayur.robottoysim.model.World
import org.junit.Assert.assertEquals
import org.junit.Test

class WorldTest {

    @Test
    fun testPlaceRobot() {
        val world = World()
        world.place(Direction.NORTH, Position(2, 2))

        val report = world.report()
        assertEquals("2,2,NORTH", report)
    }


    @Test
    fun testMoveRobot() {
        val world = World()
        world.place(Direction.NORTH, Position(2, 2))
        world.moveRobot()

        val report = world.report()
        assertEquals("2,3,NORTH", report)
    }

    @Test
    fun testMoveRobotOutOfBounds() {
        val world = World()
        world.place(Direction.NORTH, Position(2, 4))
        world.moveRobot()

        val report = world.report()
        assertEquals("2,4,NORTH", report)
    }

    @Test
    fun testTurnRobotRight() {
        val world = World()
        world.place(Direction.NORTH, Position(2, 2))
        world.right()

        val report = world.report()
        assertEquals("2,2,EAST", report)
    }

    @Test
    fun testTurnRobotLeft() {
        val world = World()
        world.place(Direction.NORTH, Position(2, 2))
        world.left()

        val report = world.report()
        assertEquals("2,2,WEST", report)
    }

    @Test
    fun testPlaceObject() {
        val world = World()
        world.place(Position(1, 1))

        val field = world.field()
        assertEquals(1, field[1][1])
    }

    @Test
    fun testPlaceObjectAndRobot() {
        val world = World()
        world.place(Direction.NORTH, Position(2, 2))
        world.place(Position(1, 1))

        val field = world.field()
        assertEquals(1, field[1][1])

        val report = world.report()
        assertEquals("2,2,NORTH", report)
    }

    @Test
    fun testMoveRobotWithObject() {
        val world = World()
        world.place(Direction.NORTH, Position(2, 2))
        world.place(Position(2, 3))

        world.moveRobot()

        val field = world.field()
        assertEquals(1, field[2][3]) // Object should be present after the robot moves

        val report = world.report()
        assertEquals("2,3,NORTH", report)
    }

}
