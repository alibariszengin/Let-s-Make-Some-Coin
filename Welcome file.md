
# 4 Different Miners


We have 4 miners using different algorithms to mine. Each one has limited number of moves to mine for each tour. With the dynamic attributes of "cost of moving", "start gold value" and "cost of mine" each one goes to mining areas to mine. Game overs when all the mines are done or 3 of 4 miners are out of the gold.

Developed in 2021.

## Table of contents
* [General info](#general-info)
* [Technologies-Tools](#technologies-tools)
* [Modules](#modules)
* [Setup](#setup)
* [Contact](#contact)


## General Info

There are 4 miners moves automatically that depends on their algorithm to mine. Each one has different way to choose and reach the gold area. The yellow areas are the gold mines with their values written on them and the black ones are secret golds. Miners can not know how much gold in these black areas. Every mine spreads randomly on the map. 

![Game Gif](https://github.com/alibariszengin/Let-s-Make-Some-Coin/blob/main/src/Oyun/lets-make-some-coin.gif?raw=true)

And finally after all the mines finished or all the miners - except one - are out of gold, game over.

## Technologies-Tools
Project is created with:
* Java 11
* Intellij Idea
* Java Swing

## Modules
There are 4 miners and their class files and the parent (extended) abstract class as "Player". 

There is a "Coin" class that randomly spread the coins on the map. Also, has the attributes of "gold ratio" as number of golds that randomly spread on map depends on maps size, "secret gold ratio" as the ratio of hidden gold to all gold and the arrays of the coordinates of the golds.

There is a "oyunTahtasi" (gameBoard) class to create the game board and players. Also manages the ongoing operations.
 
 Let see each miners algorithm to choose and mine the golds.

-  Miner A ( Upper-Left ) 
	- Chooses the closest gold to mine. 
	- 200 starter gold, 5 gold for moving cost, 5 gold for mining cost
- Miner B ( Upper-Right )
	- Chooses the gold that gives max gain of gold ( move count *5 - mine's gold value) 
	- 200 starter gold, 5 gold for moving cost, 10 gold for mining cost
- Miner C ( Lower-Right )
	- Directly chooses the closest secret mines.  
	- 200 starter gold, 5 gold for moving cost, 10 gold for mining cost
- Miner D ( Lower-Left )
	- Calculates all the other players targets and the distance between them. Chooses the mines that Miner D can arrive before the others. Calculates the gain like Miner B.
	- 200 starter gold, 5 gold for moving cost, 10 gold for mining cost

## Setup
To run this project, open the project with your IDE and run the Main class. 

## Contact

Ali Barış Zengin  -  [alibariszengin@gmail.com](mailto:alibariszengin@gmail.com)

Project Link:  [https://github.com/alibariszengin/Let-s-Make-Some-Coin](https://github.com/alibariszengin/Let-s-Make-Some-Coin)
