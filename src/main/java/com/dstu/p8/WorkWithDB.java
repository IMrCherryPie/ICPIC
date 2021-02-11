package com.dstu.p8;

import com.dstu.p6.interfaces.Student;
import com.dstu.p6.interfaces.Teacher;
import com.sun.corba.se.impl.ior.ObjectAdapterIdArray;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class WorkWithDB<T> {

    private boolean checkOfRound = false;

    public void addNewData(ArrayList<T> arrayListObject, Statement statement) {
        if (!arrayListObject.isEmpty()) {

            HashMap<String, ArrayList<String>> mapClassListField = getFields(arrayListObject);
            System.out.println(mapClassListField);
            for (int i = 0; i < arrayListObject.size(); i++) {

//                try {
//                    statement.executeUpdate("INSERT INTO" + arrayList.getClass().getName() + " student (name, patronymic, surname, `group`, course) " +
//                            "VALUES ('Victor', 'Victorov', 'Victorovich', 'Doc. of since', 'IIVT', 3)");
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }

            }
        }


    }

    private ArrayList<HashMap<String, String>> getHashMapFieldValue(HashMap<String, ArrayList<String>> mapClassListField, ArrayList<T> listObject) {

        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < listObject.size(); i++) {
            for (int j = 0; j < listFields.size(); j++) {
                key.append(listFields.get(j));
                try {
                    Field field;
                    field = listObject.get(j).getClass().getDeclaredField("group");
                    field.setAccessible(true);
                    System.out.println((String) field.get(listObject.get(j)));

                    value.append(listObject.get(i).getClass());
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                key = new StringBuilder();
            }
        }
        return list;
    }

    private HashMap<String, ArrayList<String>> getFields(ArrayList<T> arrayList) {
        HashMap<String, ArrayList<String>> mapClassField = new HashMap<String, ArrayList<String>>();
        ArrayList<String> arrayListStringOfFields = new ArrayList<>();
        Class clazz;
        try {
            clazz = Class.forName(arrayList.get(0).getClass().getName());
            clazz.newInstance();
            mapClassField.putAll(getFieldsAllSuperClass(clazz, mapClassField, arrayListStringOfFields));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return mapClassField;
    }

    private HashMap<String, ArrayList<String>> unionHashMapByKey(HashMap<String, ArrayList<String>> map1, HashMap<String, ArrayList<String>> map2) {
        HashMap<String, ArrayList<String>> newMap = new HashMap<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                newMap.put(key, map1.get(key));
            }
        }
        return newMap;

    }

    private HashMap<String, ArrayList<String>> getFieldsAllSuperClass(Class object, HashMap<String, ArrayList<String>> mapClassField,
                                                                      ArrayList<String> arrayListStringOfFields) {
        String className;
        if (object.getSuperclass() != null) {
            Class clazz;
            try {
                clazz = Class.forName(object.getSuperclass().getName());
                clazz.newInstance();
                className = clazz.getName();
                if (!clazz.getSimpleName().equals("Object")) {
                    mapClassField.putAll(getFieldsAllSuperClass(clazz, mapClassField, arrayListStringOfFields));
                }

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        className = object.getName();
        Field[] fields = object.getDeclaredFields();
        if (fields.length != 0) {
            for (int j = 0; j < fields.length; j++) {
                    ArrayList<String> l;

                    if (!mapClassField.containsKey(className)) {
                        l = new ArrayList<>();
                        l.add(fields[j].getName());
                        mapClassField.put(className, l);
                    } else {
                        l = new ArrayList<>();
                        l = mapClassField.get(className);
                        l.add(fields[j].getName());
                        mapClassField.put(className, l);
                    }
            }
        }
        return mapClassField;
    }
}
