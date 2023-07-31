package com.mayur.robottoysim

import com.mayur.robottoysim.model.Position
import com.mayur.robottoysim.model.Table
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TableTest {

    @Test
    fun testWithinBoundaries() {
        val table = Table(5, 5)
        val positionInside = Position(2, 3)
        val positionOutside = Position(6, 1)

        assertTrue(table.withinBoundaries(positionInside))
        assertFalse(table.withinBoundaries(positionOutside))
    }
}
