package com.dstu.p8.workWithDB;

import com.dstu.p6.interfaces.Man;
import com.dstu.p6.student.Student;
import com.dstu.p6.teacher.Teacher;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class WorkWithDB<T> implements com.dstu.p8.interfases.WorkWithDB {

    private boolean aFirstRound = true;
    private Statement statement;

    public void addNewData(ArrayList<T> arrayListMan, Statement statement) {
        this.statement = statement;

    }


    private HashMap<String, HashMap<String, String>> getHashMapFieldValue(HashMap<String, ArrayList<String>> mapClassListField, ArrayList<T> listObject) {

        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        String tableName;
        StringBuilder field = new StringBuilder();
        StringBuilder value = new StringBuilder();

        for (int i = 0; i < listObject.size(); i++) {

            for (Map.Entry entry : mapClassListField.entrySet()) {
                try {
                    Class clazz = Class.forName(entry.getKey().toString());

                    if (aFirstRound) {
                        tableName = clazz.getSimpleName();
                        aFirstRound = false;
                    }

                    ArrayList<String> fields = new ArrayList<>();

                    fields = mapClassListField.get(entry.getKey().toString());
                    System.out.println(fields);
                    for (int j = 0; j < fields.size(); j++) {
                        Field fieldOne;
                        fieldOne = listObject.get(i).getClass().getDeclaredField(fields.get(j));
                        fieldOne.setAccessible(true);
                        String type = fieldOne.get(listObject.get(j)).getClass().getSimpleName();

//                        Не могу понять как вытащить значение из поля родителя.

                        if (i == 1) {
                            fieldOne = listObject.get(i).getClass().getSuperclass().getDeclaredField(fields.get(j));
                            System.out.println();
                        } else {
                            System.out.println(fieldOne.get(listObject.get(j)));
                        }

                    }


                } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            aFirstRound = true;
        }
        /*for (int i = 0; i < listObject.size(); i++) {
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
        }*/
        HashMap<String, HashMap<String, String>> hashMapNTableNFieldValue = new HashMap<>();
        return hashMapNTableNFieldValue;
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
//                clazz.newInstance();
                className = clazz.getName();
                if (!clazz.getSimpleName().equals("Object")) {
                    getFieldsAllSuperClass(clazz, mapClassField, arrayListStringOfFields);
                }

            } catch (ClassNotFoundException e) {
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
