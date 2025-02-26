# Battleship
Project "Battleship" Description
Project Description: Implement the Battleship game in Java.

Functional Requirements from the Client:

Two-player Limitation:

Only two players can participate simultaneously.
Each player has a distinct name.
Each player has a 10x10 game board.
Automatic Ship Placement:

Game boards are automatically populated with ships.
Players cannot see each other's ship placements.
Ships can only be placed horizontally or vertically.
Ship configuration:
4 single-cell ships
3 two-cell ships
2 three-cell ships
1 four-cell ship
Validation ensures ships do not overlap or exceed board boundaries.
Turn-based Gameplay:

Players take turns to make moves by specifying coordinates on the board.
Players continue making moves until they hit an opponent's ship or miss.
Redundant moves (re-selecting an already targeted cell) prompt the player to choose another cell.
Game End Condition:

The game ends when one player's fleet is completely destroyed.
Upon victory, the winning player's name is displayed.
Final board states (with hits and misses marked) are displayed for both players.
Usage Scenario:

Ship Placement on the Game Board (Game Board Module):
Create an algorithm to randomly populate the game board with ships.

Implement an option for players to manually place ships (though not required by project specifications, this could be a logical extension).

Classes Involved:

Helper Class: Contains constants and utility classes.
Player Class: Manages player actions, including making moves.
Game Class: Controls the overall game process, including player creation, turn management, determining game outcomes, and ending the game.
Application Architecture:

Game Module: Manages the gameplay process, including player management, turn sequencing, victory determination, and game conclusion.
Board Module: Controls the state of the game board, including ship placement, handling attacks, and updating the board after each move.
Additional Comments:

Each cell on the board is initially a WaterCell.
When a ship is placed on a cell, it becomes a ShipCell.
Depending on the cell type, players receive feedback on their moves.
Each ShipCell contains one ship, and its status (isAlive) determines whether it's hit or sunk.
For the Game Module:

Creating Players:
Prompt the player to enter their name.
Create a new player with the specified name and a new game board.
Ask the player to choose a ship placement strategy.
The player selects from the provided options.
Populate the player's game board with ships according to the chosen strategy......

