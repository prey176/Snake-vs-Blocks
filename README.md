# Snake-vs-Blocks

## Overview

The objective of the project is to create a JavaFX application for the game - Snake vs Blocks. In this game, there is a chain of balls that has enough power to break through numbered blocks. If the chain hits a block that it can't break, the game ends.
This project has been contributed by Vaibhav Sarda and Preyansh Rastogi.

## Functionality

<ol>
    <li> The game Snake vs Blocks is a game built on Javafx.  
    <li> There is a "MainMenu" class, where there are 4 Buttons Play, LeaderBoard, How to Play, Exit.
    <li> On Clicking Play, a screen ( "Resume" Class ) appears if some previous unfinished game is there.
    <li> When the game ("PlayGame" Class) starts, a row of blocks comes after some time. Where block is assigned random color and random visibility. The PlayGame has the "Snake" as the attribute, which could move left or right with the function "display" and it could collect the "token" with subclasses "magnet", "bomb", "shield" and we checked it     parallelly whether it collects which of them using multithreading. The token class implements the Runnable Interface. It collides with the row of "blocks", and decreases the snake length by one with delay created using animation timer. 
    <li> The "walls" ensure that the snake doesn't go over it. The playgame class implements the "key event handler" and handles the input for snake movement. The snake if collects a ball then the updatelength in snake class is called, and if it collides the block, the “decreaselength” function in it gets called. There is a head class which extends the ball class and has a label for number of balls in snake.   
    <li> There are 2 seperate burst's for the snake and the block, with the block burst having random colours, with adequate delays created using animation timer. 
    <li> The Label of playerscore gets increased if the snake collides with the coin ("collidewithspecialcoin" method). There are 3 buttons pause, mainmenu and restart, whose setOnAction method are implemented for the specified purposes. The block gets down using the "movedown" method in playgame class, which is implemented using animation timer so the blocks move down whenever its handle method is called.    
    <li> The Pause Button stops the current downflow of blocks and also maintain if their is any shield time or magnet timer left. 
    <li> The "leaderboard" class stores the result as soon as the the game gets over, and presents the highest scores implemented by "sorting" the player arraylist by making the "player" class "comparable". 
    <li> The "HowtoPlay" class displays the simple rules.
    <li> Exit exits the Application.
</ol>

## Class Diagram
![Class Diagram-1](https://user-images.githubusercontent.com/44090402/103481415-e8f0e500-4e00-11eb-9889-bdbd352d1441.jpg)

## Use Case Diagram
![Use Case Diagram-1](https://user-images.githubusercontent.com/44090402/103481429-fc03b500-4e00-11eb-9bd2-09022615d6a9.jpg)
