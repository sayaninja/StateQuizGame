# cs56-games-states-quiz
======================

Zhansaya Abdikarimova
Jenny Vien

This is a state quiz that currently tests knowledge about locations of states and their capitals on US map. As for the future, it can be advanced for choosing different countries and continents. 


* javadoc: http://www.cs.ucsb.edu/~zhansaya/cs56/W14/StateQuiz/javadoc/

## Documentation

First when the quiz-game starts, it askes if user wants to be tested with states locations or their capital locations. The initila pages is in `QuizFrontPage` class. 

The program reads data in `Country` about country’s states’ names, their capitals, and locations of buttons on every state for choosing them. All the data is in `States.txt` file. As you can see, in the constructor, every Country object has its name, capital and list of its states. 
```java
public Country(){
	states = new ArrayList<State>();
	this.name = null;
	this.capital = null;
    }
``` 
and it reads all the information about country from a file
```java
public void addStates(int numberOfStates, File file) throws Exception {
	Scanner scanner = new Scanner(file);

	String line;
	int x;
	int y;

	for(int i=0;i<numberOfStates;i++){
	    line = scanner.nextLine();
	    String[] splitted = line.split(",");

	    x=Integer.parseInt(splitted[2]);
	    y=Integer.parseInt(splitted[3]);
	    states.add(new State(splitted[0],splitted[1],x,y));
	    //System.out.println(states.get(i));
	}
    }
```
* The `State` class stores information about each state of particular country
```java
public State(){
	this.name=null;
	this.capital=null;
	this.xCoord=0;
	this.yCoord=0;
    }
```

* The `GamePanel` class contains the main panel of the game. It has three main parts:
- the map of the country with colored states and button on them
- questions scroll bar
- correct answers scroll bar  

* The `Question Manager` class has the basic logic for running the quiz. It stores list of states and their capitals, generates random indexes for questions, and asks questions until all of the states asked. 

## How to run 
To start the game, use `ant run`. 

