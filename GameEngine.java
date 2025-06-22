package org.example;

import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {

        System.out.println("Welcome to Dungeon Quest!");

        Scanner scn = new Scanner(System.in);
        System.out.println("1. New game");
        System.out.println("2. Load Game");
        System.out.println("Choose an Option [1/2]: ");
        int menu = Integer.parseInt(scn.nextLine());

        Player player;
        Room currentRoom;

        Room entrance = new Room("You are at entrance of dungeon.");
        Room hallway = new Room("You are in long hallway. It's eerily quiet.");
        Room armory = new Room("You have entered the armory. Rusty wepons line the wall.");
        Room bossRoom = new Room("A giant ogre roars, This is Boss Room!!! ");


        hallway.setEnemy(new Enemy("Skeleton", 15));
        armory.setItem("Sword");
        bossRoom.setEnemy(new Enemy("Ogre", 40));

        // Connecting Rooms
        entrance.setExit("north", hallway);
        hallway.setExit("south", entrance);
        hallway.setExit("east", armory);
        armory.setExit("west", hallway);
        hallway.setExit("north", bossRoom);
        bossRoom.setExit("south", hallway);






        if(menu == 2)
        {   // resume the saved game
            GameState gameStateloaded = SaveManager.loadGame();
            if(gameStateloaded != null)
            {
                player = gameStateloaded.getPlayer();
                currentRoom = gameStateloaded.getRoom();
                System.out.println("🟢 Game loaded! Welcome back, "  + player.getName());
            }
            else{
                System.out.println("⚠️ Failed to load. Starting new game.");

                System.out.println("Enter Your name");
                String name = scn.nextLine();
                player = new Player(name);
                currentRoom = entrance;
            }

        }
        else {

            System.out.println("Enter Your name");
            String name = scn.nextLine();
            player = new Player(name);
            Room room = new Room("You are in spooky dungeon.");
            room.setEnemy(new Enemy("Goblin", 20));
            room.setItem("Health Potion");
            currentRoom = entrance;
        }

        while (true)
        {

            System.out.println("Your current health: " + player.getHealth());

            if(currentRoom.getEnemy() != null && currentRoom.getEnemy().getName().equalsIgnoreCase("Ogre") && !currentRoom.getEnemy().isAlive())
            {
                System.out.println("🎉 You have defeated the Ogre and completed the Dungeon Quest! 🎉");
                break;
            }
            if(player.getHealth() <= 0)
            {
                System.out.println("Player don't have power !!!");
                break;
            }
            System.out.println("Let's begin, You are at Room : " + currentRoom.getDescription());

            if(currentRoom.getEnemy() != null && currentRoom.getEnemy().isAlive())
            {
                System.out.println("Enemy Spotted : "+ currentRoom.getEnemy().getName());
                System.out.println("Fight or Flee ?");
                String choice = scn.nextLine();

                if(choice.equalsIgnoreCase("fight"))
                {
                    while (currentRoom.getEnemy().isAlive())
                    {
                        currentRoom.getEnemy().takeDamage(10);
                        System.out.println("You hit the enemy : Enemy Health Power is : " + currentRoom.getEnemy().getHealth());
                        if(currentRoom.getEnemy().isAlive())
                        {
                            player.takeDamage(5);
                            System.out.println("Enemy hit back, Player Health Power is: "+player.getHealth());
                        }
                    }
                    System.out.println("You defeated the enemy!!!!");

                }
                else{
                    System.out.println("You flee away safely");
                    System.out.println("Do you want to save the game  💾 [save], or ❌ [exit] the game");
                    String flee_choice = scn.nextLine();
                    if(flee_choice.equalsIgnoreCase("save"))
                    {

                        SaveManager.saveGame(new GameState(player, currentRoom));
                        continue;
                    }
                    else if(flee_choice.equalsIgnoreCase("exit"))
                    {
                        System.out.println("See you next Time 👋 Exiting game. Goodbye!");
                        System.exit(1);
                    }
                    else
                    {
                        System.out.println("Choose correct Option----------");
                        continue;
                    }
                }
            }
            // mara peete ho gyi enemy ke sath ab item h to item uthao or aage badho
            if(currentRoom.getItem() != null)
            {
                System.out.println("You found an item " + currentRoom.getItem());
                System.out.println("Pick it up?[Yes/no]");
                String pick = scn.nextLine();
                if(pick.equalsIgnoreCase("yes"))
                {
                    player.addItem(currentRoom.getItem());
                    currentRoom.setItem(null);
                }
            }

            // player options
            System.out.println("What move you want to take next ?");
            System.out.println("➡️ [Explore Direction], 📦 [Collect Inventory], 💾 [Save], ❌ [Exit]");
            System.out.print("> ");

            String input = scn.nextLine().toLowerCase();

            switch (input) {
                case "save": {
                    SaveManager.saveGame(new GameState(player, currentRoom));
                    continue;
                }
                case "exit": {
                    System.out.println("👋 Exiting game. Goodbye!");
                    return;
                }
                case "inventory": {
                    player.showInventory();
                    break;
                }
                default: {
                    System.out.println("Where do you want to go?[direction]");
                    System.out.println("Exit : " + currentRoom.getExits().keySet());
                    String direction = scn.nextLine();

                    Room nextRoom = currentRoom.getExit(direction.toLowerCase());
                    if (nextRoom != null) {
                        currentRoom = nextRoom;
                    } else {
                        System.out.println("You can't go in that direction!!");
                    }

                    break;
                }
            }

        }

        scn.close();

    }
}