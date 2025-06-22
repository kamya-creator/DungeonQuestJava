package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    private String name;
    private int health;
    private List<String> inventory;

    Player(String name)
    {
        this.name = name;
        this.health = 50;
        this.inventory = new ArrayList<>();
    }

    public void takeDamage(int damage)
    {
        this.health = this.health - damage;
    }
    public void heal(int points)
    {
        this.health = this.health + points;
    }

    public void addItem(String item)
    {
        this.inventory.add(item);
    }

    public void showInventory()
    {
        if(inventory.isEmpty())
        {
            System.out.println("Inventory is Empty!!!");
        }
        else{
            System.out.println("Inventory : "+ this.inventory);
        }
    }
    public int getHealth()
    {
        return this.health;
    }
    public String getName()
    {
        return this.name;
    }

}
