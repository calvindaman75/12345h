[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13516281)
# Project 4: Absurdle
**Objective:** 
In this project, you will implement a variant of Wordle, one where the computer fights back against the user. Instead of picking a chosen word at the beginning of the game, your program will instead consider a large list of possible words, and intentionally keep changing its chosen word to prolong the game as much as possible. 

This project is intended to practice working with ArrayLists. 

**Requirements:** 
In addition to performing all Programming Tasks, you must also write comments in your program. These comments should explain decisions or lines of code that are not immediately apparent to the reader. You may design your program to be intuitive for users to use, but your program must still adhere to the specifications laid out below and follow the user interface guidelines.

**Grading:**
This project is worth **100** points. In addition, your comments worth **10** points. Your comments should both explain programming decisions and reflect on difficult portions of the project.    

**Explanation:**
Suppose that the list of possible "chosen" words is just: ally, beta, cool, deal, else, flew, good, hope, ibex.
If the user were to guess, "argh", the following five "patterns" are possible: 

- ⬜⬜⬜⬜ — *cool, else, flew, ibex*
- ⬜⬜⬜🟨 — *hope*
- ⬜⬜🟨⬜ — *good*
- 🟨⬜⬜⬜ — *beta, deal*
- 🟩⬜⬜⬜ — *ally*

We are going to use the word "pattern" to refer to the sequence of emojis corresponding to which characters matched our guess and where.
For instance, the "pattern" 🟨⬜⬜⬜ corresponds to both "beta" and "deal" since they have an a, just in the wrong location. 

Also, we won't be actually printing the square emojis out. We will be using colored text instead. These square emojis will be represented internally (in our program) as integer arrays, where -1 corresponds to the empty emoji, 0 corresponds to the yellow one, and 1 corresponds to the green one.

Hypothetically, the program, if it wants to prolong the game as long as possible, should choose the pattern ⬜⬜⬜⬜ corresponding to the words *cool, else, flew, ibex* since it's the pattern with the most words in it. While the list of possible chosen words has been decreased, the program will choose the pattern that decreases the list of target words the least. 

Next, the user will go again, and this time if they guess "beta", the possible patterns are: 

- ⬜⬜⬜⬜ — *cool*
- ⬜🟨⬜⬜ — *else, flew*
- 🟨🟨⬜⬜ — *ibex*

Now, our program should pick ⬜🟨⬜⬜ since it is the pattern that has two chosen words still. Notice that while the ⬜⬜⬜⬜ pattern is farther from being solved, it only corresponds to one word, so it might actually be easier for the user to find. 

Next, the user will go again, and this time if they guess "flew", the possible patterns are: 

- ⬜🟩🟨⬜ — *else*
- 🟩🟩🟩🟩 — *flew*

There's a tie now, so the program should choose "else" as the chosen word because it would prolong the game. 

At this point, the program is locked into "else" as a chosen word, and so the rest continues like a normal game of Wordle. 

**Programming Task:**
You will implement all of your code into a .java file called **Runner** that should be able to perform the following:

- Read in the entire list of possible five-letter chosen words and store it as an ArrayList called words.
- Implement the Weirdle game as described in the Explanation section above.
  - It should be programmed to make the game as long for the user as possible.

You need the following methods: 
- public static int[] calculate(String chosen, String guess)
  - This method should calculate the pattern for a given guess and a given chosen word and return the associated pattern.
  - `calculate("abbey", "bebop")` — 🟨🟨🟩⬜⬜.
    Notice how the middle letter 'b' in the guess "bebop" is green, while the first letter 'b' is yellow. Green tiles are assigned before yellow tiles. In this case, the method should return the integer array [0, 0, 1, -1, -1]. 
  - `calculate("abbey", "keeps")` — ⬜🟨⬜⬜⬜.
    Notice how only the first letter 'e' in the guess "keeps" is yellow, while the second letter 'e' is gray. If there are multiple places for a yellow tile, choose the leftmost places. In this case, the method should return the integer array [-1, 0, -1, -1, -1].
  - The calculate() method should follow standard Wordle() rules for which characters are empty, yellow, and green. 

- public static ArrayList\<String\> makeGuess(String guess, ArrayList\<String\> words)
  - This method should accept a guess and compare it to the words ArrayList.
  - Using calculate(), it should return the updated ArrayList of possible chosen words.
  - In addition to that, it should print colored text corresponding to the pattern of the guess.
    - To this end, it should use the printWord() method.
  - If the guess is not in the list of 2309 possible five-letter words, ask the user to input another guess. 
       
- public static void printWord(String word, int[] pattern)
  - This method should, given a word and an associated pattern, print the word with correctly colored letters.

- public static void checkFinished()
  - The parameters of this method are intentionally left empty, so it's up to you to decide on the parameters. 
  - This method should check if the game of Weirdle is over, as in, if the user has guessed the word successfully. 
- Beyond these methods, your program will need to have some other things to work successfully. You need:
  - An ArrayList of Strings. This ArrayList will store the guesses that users have made.
  - An ArrayList of int[] arrays. This ArrayList will store the patterns that have resulted from user guesses.
  - A loop of some kind to play the game and keep prompting the user for guesses until it's over.
  - A message introducing the game to the user.
  - A message once the user has won.
  - Probably at least one helper method to make methods like calculate() and makeGuess() easier to write and run. 
**Resources:**

You have a "words.txt" text file. This file contains all 2309 possible five letter words that are solutions to Wordle/Absurdle. The code to read these files is already written in Runner.java.

In addition to this, there are three constants in Runner.java related to printing colored text as well as two commented lines of code explaining how they work. You should not change these constants. 

**Extension:**

1) Modify your program so that once the user finds the solution, the program prints a recap that shows the number of guesses and all patterns: 

Absurdle 4/∞

⬜⬜🟨⬜⬜  
🟩🟨⬜⬜🟨  
🟩🟨⬜🟩⬜  
🟩🟩🟩🟩🟩

2) Make your own variant of Wordle that's somehow harder than Absurdle!

       
