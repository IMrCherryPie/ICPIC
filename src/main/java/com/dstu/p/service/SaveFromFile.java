package com.dstu.p.service;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFromFile {

    public static void save(String fileName, String str) {

        try(FileWriter writer = new FileWriter(fileName, false))
        {
            // запись всей строки
            writer.write(str);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
