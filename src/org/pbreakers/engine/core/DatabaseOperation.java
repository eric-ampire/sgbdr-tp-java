package org.pbreakers.engine.core;

import org.pbreakers.engine.persistance.Database;

import java.io.File;

public class DatabaseOperation {

    public static boolean createDatabasee(Database database) {
        String fileName = database.getNom();
        String filePath = "database/" + fileName + ".json";

        File databaseFile = new File(filePath);
        if (databaseFile.exists()) {
            new Exception("File exist").printStackTrace();
            return false;
        } else {
            try {
                boolean fileIsCreated = databaseFile.createNewFile();

                if (fileIsCreated) {
                    String json = GsonInstance.getInstance().toJson(database);
                    FileUtil.writeInFile(filePath, json);
                }

                return fileIsCreated;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static boolean deleteDatabase(Database database) {
        String fileName = database.getNom();
        String filePath = "database/" + fileName + ".json";

        File databaseFile = new File(filePath);
        if (databaseFile.exists()) {
            return databaseFile.delete();
        } else {
            return false;
        }
    }

    public static boolean updateDatabasee(String newName, String oldName) {

        File newFile = new File("database/" + newName + ".json");
        File oldFile = new File("database/" + oldName + ".json");


        return oldFile.renameTo(newFile);
    }
}
