package com.mayur.robottoysim

import com.mayur.robottoysim.model.Position
import com.mayur.robottoysim.model.Table
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TableTest {

    @Test
    fun testWithinBoundaries() {
        val table = Table(4, 4)
        val positionInside = Position(2, 3)
        val positionOutside = Position(5, 1)

        assertTrue(table.withinBoundaries(positionInside))
        assertFalse(table.withinBoundaries(positionOutside))
    }
}
