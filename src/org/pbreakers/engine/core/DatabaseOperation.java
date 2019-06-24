package org.pbreakers.engine.core;

import org.pbreakers.engine.persistance.Database;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DatabaseOperation {

    public static boolean createDatabasee(Database database) {
        String fileName = database.getNom();
        String filePath = "database/" + fileName + ".json";

        File databaseFile = new File(filePath);
        if (databaseFile.exists()) {
            return false;
        } else {
            // dfdfdfdfd
            return true;
        }
    }

    public static void  deleteDatabase(Database database) {
        String fileName = database.getNom();
        String filePath = "database/" + fileName + ".json";


    }

    public static void  updateDatabasee(Database newDatabase, Database old) {

    }
}
