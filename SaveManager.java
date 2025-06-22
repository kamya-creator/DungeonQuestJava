package org.example;

import java.io.*;

public class SaveManager  {

    private static final String SAVE_FILE = "savegame.dat";

    public static void saveGame(GameState state)
    {
        try {
            FileOutputStream fileStream = new FileOutputStream(SAVE_FILE);

            ObjectOutputStream os_out = new ObjectOutputStream(fileStream);

            os_out.writeObject(state);
            System.out.println("✅ Game saved successfully.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("❌ Error saving game: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static GameState loadGame()
    {
        try {
            FileInputStream fileInputStream = new FileInputStream(SAVE_FILE);
            ObjectInputStream os_in = new ObjectInputStream(fileInputStream);

            GameState state = (GameState) os_in.readObject();
            return state;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
