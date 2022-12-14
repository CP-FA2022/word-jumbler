# Word Jumbler

## Table of Contents

1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview

### Description

The app will function as a letter-jumble game where a user will have a certain amount of time to create as many words as possible.

### App Evaluation

- **Category:** Gaming
- **Mobile:** The mobile app will be utilizing push notifications and real-time data 
- **Story:** Many people enjoy puzzle apps or brainteasers in some form, even casual puzzle enjoyers could use the app
- **Market:** Many people enjoy puzzle apps or brainteasers in some form, even casual puzzle enjoyers could use the app
- **Habit:** The user could be opening the app just out of slight boredom or just as a daily brainteaser but if the user enjoys the game it wouldnt be hard to get them to return.
- **Scope:** This app is doable within the timeframe, the product is very defined.

## Product Spec

### 1. User Features (Required and Optional)

**Required Features**

* A user must be able to play a complete game.
* The user's score will be added to a live global leaderboard
* The user will be able to track their progress
* The user can earn achievements for daily use

**Stretch Features**

* Customizable user profiles
* Challenge scenarios
* Other game modes
* User data analytics

### 2. Screen Archetypes

- Login Screen
  - User can login
- Registration Screen
  - User can create a new account
- Home screen
    - User can start a game with their desired game settings
- Game screen
    - User will play a complete game on this screen
- Game over screen
    - User will be directed to this screen when the game is finished
- Record screen
    - User can see their game records
- Leaderboard screen
    - User can view global leaderboard

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home
* Leadearboard
* Records

**Flow Navigation** (Screen to Screen)

- Login Screen
  - => Home
- Registration Screen
  - => Home
- Home Screen
    - => Game Screen
- Game Screen
    - => Game Over Screen
- Game Over Screen
    - => Home
- Leaderboard
    - => None

## Wireframes

[Add picture of your hand sketched wireframes in this section]
![](https://github.com/CP-FA2022/word-jumbler/blob/main/milestones/IMG_5107.jpg)

## Milestones
### Milestone 1
App theme created for uniform colors and font throughout the app

![](https://github.com/CP-FA2022/word-jumbler/blob/main/milestones/Milestone1.gif)

### Milestone 2
Created 5 new activity files: home page, game page, login page, registration page, and load save game page
Connected game page and load/save game page to home page through intents
#### User Stories
- [ ] User opens the app and is directed to the login/registration
  - [x] User is directed to the main home page activity
    - [x] User can open a new game
      - [ ] User can play a full game
    - [x] User can open the load saved game page
      - [ ] User can open a saved game

![](https://github.com/CP-FA2022/word-jumbler/blob/main/milestones/Milestone2.gif)

### Milestone 3
Implemented fragment container holding the three previous functions of the main activity, allowing users to switch between launching a game with desired settigns, viewing the leaderboard, or loading a saved game

Using wordle solution data, GameActivity now has a list of valid words that can be referenced to judge guesses

- [ ] User opens the app and is directed to the login/registration
  - [x] User is directed to the main home page activity
    - [x] User can select between fragment pages
      - [x] User can open a new game from the launch game fragment
      - [ ] User can load a saved game
      - [ ] User can view the leaderboard
    
![](https://github.com/CP-FA2022/word-jumbler/blob/main/milestones/Milestone3.gif)

### Milestone 4

Created + integrated Firebase project into app. User data will be logged and stored in Firestore to display user history and leaderboards. Firebase Authentication implemented to prevent unauthenticated access to Firestore data.

Implemented Flexbox Layout to programtically hold TextViews for the user to select letters for their guesses.

- [x] User opens the app and is directed to the login/registration
  - [x] User is directed to the main home page activity
    - [x] User can select between fragment pages
      - [x] User can open a new game from the launch game fragment
        - [x] User gets a random selection of letters to create words based on difficulty level
        - [ ] User can play a game
      - [ ] User can view the leaderboard
     
![](https://github.com/CP-FA2022/word-jumbler/blob/main/milestones/Milestone4.gif)

### Milestone 5

Implemented game functionality where a player can initialize a game with varying difficulty levels. Difficulty level determines amount of letters to jumble. The user the has until the timer completes to create as many 4-6 letter words as possible and will be scored based on letter length
Connected data flow between GameActivity and GameOverActivity
Added navigation between GameOverActivity, HomeActivity, and GameActivity

- [x] User opens the app and is directed to the login/registration
  - [x] User is directed to the main home page activity
    - [x] User can select between fragment pages
      - [x] User can open a new game from the launch game fragment
        - [x] User gets a random selection of letters to create words based on difficulty level
        - [x] User can open a new game
        - [x] User can play a full game
      - [ ] User can view the leaderboard

![](https://github.com/CP-FA2022/word-jumbler/blob/main/milestones/Milestone5.gif)

### Milestone 6

Automatically saves user game result at end of game, uploads to personal user history and to global leaderboard
Leaderboard fragment displaying top 10 global scores
User can choose their own display name to appear on the leaderboard and game

- [x] User opens the app and is directed to the login/registration
  - [x] User is directed to the main home page activity
    - [x] User van view their highest score and time last played
    - [x] User can select between fragment pages
      - [x] User can open a new game from the launch game fragment
        - [x] User gets a random selection of letters to create words based on difficulty level
        - [x] User can open a new game
        - [x] User can play a full game
      - [x] User can view the leaderboard
  
![](https://github.com/CP-FA2022/word-jumbler/blob/main/milestones/Milestone6.gif)

