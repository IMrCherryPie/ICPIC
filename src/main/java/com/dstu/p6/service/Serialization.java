/**
 * Product by The Ivan
 * The class takes any object and serializes / deserializes it.
 */

package com.dstu.p6.service;

import java.io.*;
import java.util.ArrayList;

public class Serialization<T>
        implements com.dstu.p6.interfaces.Serialization {

    public void readObject(String filePath){
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            arrayList.add ((T) ois.readObject());

            for (T t : arrayList) {
                System.out.println(t);
            }

            ois.close();

            new ServiceReadWrite().toLog("Line 24 * src/main/java/com/dstu/p/service/Serialization.java *  " +
                    "Десериализация объектов класса: " + arrayList.get(0).getClass() + " прошла успешно" );
        } catch (IOException | ClassNotFoundException e) {
            new ServiceReadWrite().toLog("Line 26 * src/main/java/com/dstu/p/service/Serialization.java *  " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void writeObject(String filePath, ArrayList<T> arrayList){
        try {
            FileOutputStream fos = new FileOutputStream(filePath);// Преобразует объект в последовательность байтов.
            ObjectOutputStream oos = new ObjectOutputStream(fos); // Записывает последовательность абйтов в файл

            for (T t: arrayList) {
                oos.writeObject(t);
            }

            oos.close();
            new ServiceReadWrite().toLog("Line 24 * src/main/java/com/dstu/p/service/Serialization.java *  " +
                    "Сериализация объектов класса: " + arrayList.get(0).getClass() + " прошла успешно" );
        } catch (IOException e) {
            System.err.println("Нет файла fos для oos или нет файла в директории для сериализации");
            e.printStackTrace();
        }
    }
}
