package org.example;

import java.io.Serializable;

public class GameState implements Serializable {
    Player player;
    Room room; // Room m enemy h or enemy bhi implement kr rha h serializable to to vo bhi save ho jayega

    public GameState(Player player, Room currentRoom)
    {
        this.player = player;
        this.room = currentRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getRoom() {
        return room;
    }

}
