# Toy Robot Simulation - README

This application is a simulation of a toy robot moving on a square tabletop of dimensions 5 units x 5 units. The robot is free to roam around the surface of the table, but it must be prevented from falling to destruction. Any movement that would result in the robot falling from the table is ignored, but further valid movement commands are allowed.

## Commands

- `PLACE X,Y,F`: Place the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST, or WEST. The origin (0,0) is considered to be the SOUTH-WEST most corner. The first valid command to the robot must be a PLACE command. Any sequence of commands may be issued after that, including another PLACE command. The application discards all commands in the sequence until a valid PLACE command has been executed.

- `MOVE`: Move the toy robot one unit forward in the direction it is currently facing.

- `LEFT`: Rotate the robot 90 degrees to the left without changing its position.

- `RIGHT`: Rotate the robot 90 degrees to the right without changing its position.

- `REPORT`: Announce the X, Y, and F (facing direction) of the robot. This can be in any form, but standard output is sufficient.

## How to Run

1. Clone the repository in your Android Studio.
2. Build and Run the project from Android Studio on your Emulator or any Android Device.
3. Once the App is installed You will see a UI with: <br>
Input EditText View, Submit Button, Output Text<br>
You have to enter the command ONE PER LINE. Press Enter on keyboard after each valid command.<br>
For Example:Your EditText should look like follow<br>
PLACE 1,2,NORTH<br>
MOVE<br>
RIGHT<br>
MOVE<br>
LEFT<br>
REPORT<br>
<br>
Once all the commands are entered, Press Submit Button and the Output will appear in OutputTextView.<br>
<br>
I have also written Test cases using JUnit. You can run them all or individually from Android Studio form test package.<br>
<br>


## Test Data

Here are some test data examples to exercise the application:

a) `PLACE 0,0,NORTH MOVE REPORT`<br>
   - Output: `0,1,NORTH`

b) `PLACE 0,0,NORTH LEFT REPORT`<br>
   - Output: `0,0,WEST`

c) `PLACE 1,2,EAST MOVE MOVE LEFT MOVE REPORT`<br>
   - Output: `3,3,NORTH`


## Created By
Mayur Patil
