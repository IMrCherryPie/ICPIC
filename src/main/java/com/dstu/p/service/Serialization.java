package com.dstu.p.service;

import java.io.*;
import java.util.ArrayList;

public class Serialization<T>
        implements com.dstu.p.interfaces.Serialization {

    public void readObject(String filePath){
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            arrayList.add ((T) ois.readObject());
            arrayList.add((T) ois.readObject());

            for (T t : arrayList) {
                System.out.println(t);
            }

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeObject(String filePath, ArrayList<T> list){
        try {
            FileOutputStream fos = new FileOutputStream(filePath);// Преобразует объект в последовательность байтов.
            ObjectOutputStream oos = new ObjectOutputStream(fos); // Записывает последовательность абйтов в файл
            for (T t: list) {
                oos.writeObject(t);
            }
            oos.close();
        } catch (IOException e) {
            System.err.println("Нет файла fos для oos или нет файла в директории для сериализации");
            e.printStackTrace();
        }
    }
}
