package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // object
        String strTest01 = "kkyu";
        String strTest02 = "kkyu";
        String strTest03 = "kkyu1";
        System.out.println("String equals = " + strTest01.equals(strTest02));
        System.out.println("strTest01 hashcode = " + strTest01.hashCode());
        System.out.println("strTest02 hashcode = " + strTest02.hashCode());
        System.out.println("strTest03 hashcode = " + strTest03.hashCode());

        System.out.println("======================================");
        System.out.println();

        Person01 person001 = new Person01(10, "kkyu");
        Person01 person002 = new Person01(10, "kkyu");
        Person01 person003 = new Person01(10,"test");
        System.out.println("person001 equalse = " + person001.equals(person001));
        System.out.println("person001 equalse = " + person001.equals(person002));
        System.out.println("person001 equalse = " + person001.equals(person003));
        System.out.println("person001 person001 hashcode = " +person001.hashCode());
        System.out.println("person001 person002 hashcode = " +person002.hashCode());
        System.out.println("person001 person003 hashcode = " +person003.hashCode());

        System.out.println("======================================");
        System.out.println();

        // @Override equals, hashCode
        Person person01 = new Person(10, "kkyu");
        Person person02 = new Person(10, "kkyu");
        Person person03 = new Person(10,"test");
        System.out.println("Person equalse = " + person01.equals(person02));
        System.out.println("Person equalse = " + person01.equals(person03));
        System.out.println("Person person01 hashcode = " +person01.hashCode());
        System.out.println("Person person02 hashcode = " +person02.hashCode());
        System.out.println("Person person03 hashcode = " +person03.hashCode());

        System.out.println("======================================");
        System.out.println();

        Set<String> set = new HashSet<>();
        set.add("kkyu");
        set.add("kkyu01");
        set.add("kkyu02");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(iterator.hashCode());
        }

    }
}

class Person01 {

    private final int number;
    private final String name;

    Person01(int number, String name) {
        this.number = number;
        this.name = name;
    }

}

class Person {
    private final int number;
    private final String name;


    Person(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return number == person.number && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return number == person.number && Objects.equals(name, person.name);
//    }
//
//    @Override public int hashCode() {
//        final int PRIME = 31;
//        int result = 1;
//        result = PRIME * result + getNumber();
//        return result;
//    }



}

