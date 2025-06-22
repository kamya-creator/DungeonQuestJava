# 🧙‍♂️ Dungeon Quest - A Java Text-Based Adventure Game

Welcome to **Dungeon Quest**, a console-based adventure game built entirely in Java. Fight enemies, collect items, explore dark dungeons, and defeat the final boss — all through your terminal!

This project showcases practical usage of **Object-Oriented Programming**, **Java Serialization**, and **basic game logic design** in a clean and engaging format.

---

## 🎮 Features

- ⚔️ Battle enemies (Skeletons, Goblins, and the Ogre Boss)
- 🎒 Inventory system with item collection
- 🗺️ Move between interconnected rooms using directions
- 💾 Save and Load your game progress using Java `Serializable`
- ❤️ Health system and combat damage
- 📜 Text-based command input (like early adventure RPGs)

---

## 📸 Demo (Coming Soon!)

> *“Fight the Skeleton… Flee from the Ogre… or wield your Sword to victory!”*

> You can run the game in any Java console and experience the dungeon firsthand.

---

## 📁 Project Structure

```bash
DungeonQuestJava/
├── src/org/example/
│   ├── GameEngine.java       # Main class to run the game
│   ├── Player.java           # Player with health, inventory
│   ├── Enemy.java            # Enemy with HP and damage logic
│   ├── Room.java             # Represents rooms with exits, enemies, and items
│   ├── GameState.java        # Serializable class to hold player and room info
│   └── SaveManager.java      # File I/O for saving and loading
└── README.md
