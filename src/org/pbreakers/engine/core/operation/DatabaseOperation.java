package org.pbreakers.engine.core.operation;

import org.pbreakers.engine.core.file.FileUtil;
import org.pbreakers.engine.core.gson.GsonInstance;
import org.pbreakers.engine.persistance.Database;

import java.io.File;

public class DatabaseOperation {

    public static boolean createDatabasee(Database database) {


        File databaseFile = new File(database.getDatabasePath());
        if (databaseFile.exists()) {
            new Exception("File exist").printStackTrace();
            return false;
        } else {
            try {
                boolean fileIsCreated = databaseFile.createNewFile();

                if (fileIsCreated) {
                    String json = GsonInstance.getInstance().toJson(database);
                    FileUtil.writeInFile(database.getDatabasePath(), json);
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
        String filePath = "operation/" + fileName + ".json";

        File databaseFile = new File(filePath);
        if (databaseFile.exists()) {
            return databaseFile.delete();
        } else {
            return false;
        }
    }

    public static boolean updateDatabasee(String newName, String oldName) {

        File newFile = new File("operation/" + newName + ".json");
        File oldFile = new File("operation/" + oldName + ".json");


        return oldFile.renameTo(newFile);
    }
}
