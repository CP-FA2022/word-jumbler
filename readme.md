# Milestone 1 - Word Jumbler

## Table of Contents

1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview

### Description

The app will function as a letter-jumble game where a user will have a certain amount of time to create as many words as possible.

### App Evaluation

- **Category:** Gaming
- **Mobile:** The mobile app will be utilizng push noitifications and real-time data 
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
* The user can earn achievments for daily use

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
![](https://github.com/CP-FA2022/app/blob/main/IMG_5107.jpg)

## Milestones
### Milestone 1
App theme created for unifrom colors and font throughout the app
![](https://github.com/CP-FA2022/app/blob/main/Kapture%202022-10-24%20at%2023.47.36.gif)

### Milestone 2
Created 5 new activity files: home page, game page, login page, registration page, and load save game page
Connected game page and loadsave game page to home page through intents
#### User Stories
- [ ] User opens the app and is directed to the login/registration
  - [ x ] User is directed to the main home page activity
    -  [ x ] User can open a new game
      -  [ ] User can play a full game
    -  [ X ] User can open the load saved game page
      -  [ ] User can open a saved game
![](https://github.com/CP-FA2022/app/blob/main/Milestone2.gif)
