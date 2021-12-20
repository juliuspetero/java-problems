package com.coding;


import com.coding.learnings.annotation.JsonSerializationException;
import com.coding.learnings.annotation.ObjectToJsonConverter;
import com.coding.learnings.annotation.Person;

public class Main {

    public static void main(String[] args) throws JsonSerializationException {
        Person person = new Person("soufiane", "cheouati", "34");
        String jsonString = ObjectToJsonConverter.convertToJson(person);
        System.out.println(jsonString);
    }
}
