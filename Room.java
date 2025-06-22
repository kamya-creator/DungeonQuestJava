package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Room implements Serializable {

    private String description;
    private Enemy enemy;
    private String item;
    private Map<String,Room> exit; // direction->room (har room m ek na ek direction se dusre room tak jane ka rasta exits krta h

    public Room(String description)
    {
        this.description = description;
        exit = new HashMap<>();
    }

    public String getDescription() {
        return description;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String  getItem() {
        return item;
    }

    public void setItem(String  item) {
        this.item = item;
    }

    public void setExit(String direction, Room room)
    {
        exit.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction)
    {
        return exit.get(direction.toLowerCase());
    }

    public Map<String, Room> getExits() {
        return exit;
    }
}
