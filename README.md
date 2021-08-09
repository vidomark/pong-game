# Pong game

Java swing application.

## Installation

1. Clone this repository: `git clone https://github.com/vidomark/pong-game.git`
2. Go to the root of the directory of the project
3. Run `mvn clean package`
4. Run `mvn exec:java -Dexec.mainClass=PongGame `

## Usage

- The left paddle is controlled by the W, S keys
- The right paddle is controlled by they UP and DOWN arrows
- To exit the game, close the app

## About

The game is score based. Whenever a player cannot defend the ball, the other gets a point, then the ball gets replaced from the middle to a random direction, diagonally. Their is no AI implemented, it was intended to be a practice project.
