package org.example;

import java.io.Serializable;

public class Enemy implements Serializable {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage)
    {
        this.health = this.health - damage;
    }
    public boolean isAlive()
    {
        return this.health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
