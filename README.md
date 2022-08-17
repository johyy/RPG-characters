# RPG Characters

The goal of this project was to build a Java console application with Unit Testing. Requirements for this project were given in Experis Bootcamp "Java Fullstack". 

## Table of Contents

- [Background](#background)
- [Install](#install)
- [Usage](#usage)

## Background

This Java console application demonstrates a Role Playing Game. In this game you can select a character and name it. With this character you're able to equip armor and a weapon. You can also deal damage. The amount of damage depends on the character's class, current level, armor and weapon selected.

The character classes are:

- Mage
- Ranger
- Rogue
- Warrior

The types of armor used for equipment are:

- Cloth (Mage)
- Leather (Ranger, Rogue)
- Mail (Ranger, Rogue, Warrior)
- Plate (Warrior)

The types of weapons used for equipment are:

- Axe (Warrior)
- Bow (Ranger)
- Dagger (Rogue)
- Hammer (Warrior)
- Staff (Mage)
- Sword (Rogue, Warrior)
- Wand (Mage)

The slots used to equip items are:

- Head
- Body
- Legs
- Weapon

More instructions for playing are presented when running the application.

## Install

- Install JDK 18
- Install IntelliJ
- Clone the repository
- Open the `RPG-characters` folder in IntelliJ

## Usage

### Application

- Open the `Main` file in `src` directory
- Run the application by clicking the green play button
- The `Main` file contains instructions for using the methods

### Tests

- Right-click the `tests` folder
- Select `Run 'All Tests'`