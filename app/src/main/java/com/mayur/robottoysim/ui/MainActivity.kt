package com.mayur.robottoysim.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mayur.robottoysim.databinding.ActivityMainBinding
import com.mayur.robottoysim.model.Direction
import com.mayur.robottoysim.model.Position
import com.mayur.robottoysim.model.World
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            val input = binding.inputEditText.text
            if (input != null && input.isNotEmpty()) {
                val result = processCommand(input.toString())
                binding.outputTextView.text = result
            }
        }

    }

    private fun processCommand(commands: String): String? {
        val logger = Logger.getLogger("ProcessCommand")
        val world = World()

        val lines = commands.trim().lines()

        for (command in lines) {
            val placeRegex = Regex("(PLACE) ([0-9]),([0-9]),(NORTH|EAST|SOUTH|WEST)")

            when {
                command.matches(placeRegex) -> {
                    placeRegex.matchEntire(command)?.destructured?.let { (_, x, y, facing) ->
                        world.place(Direction.valueOf(facing), Position(x.toInt(), y.toInt()))
                    }
                }
                command == "MOVE" -> world.moveRobot()
                command == "RIGHT" -> world.right()
                command == "LEFT" -> world.left()
                command == "REPORT" -> logger.info(world.report())
                else -> logger.info("Ignoring invalid command: $command")
            }
        }

        return world.report()
    }
}