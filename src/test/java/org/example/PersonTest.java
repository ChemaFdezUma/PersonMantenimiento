package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    public void testConstructor() {
        Person person = new Person("John Doe", 25, "Male");
        assertEquals("John Doe", person.name());
        assertEquals(25, person.age());
        assertEquals("Male", person.gender());
    }
    @Test
    public void shouldThrowExceptionName(){
        assertThrows(RuntimeException.class,()->{new Person("",40,"Female");});
    }
    @Test
    public  void shouldThrowExceptionAge(){
        assertThrows(RuntimeException.class,()->{new Person("Miriam",-1,"Female");});
    }
    @Test
    public  void shouldThrowExceptionGender(){
        assertThrows(RuntimeException.class,()->{new Person("Miriam",-1,"m");});
    }
    @Test
    public void testAverageAgePerGenderMightGiveRight() {
        Person p1 = new Person("John", 21, "Male");
        Person p2 = new Person("Jane", 22, "Female");
        Person p3 = new Person("Mike", 19, "Male");
        List<Person> persons = Arrays.asList(p1, p2, p3);

        double[] averageAge = Person.averageAgePerGender(persons);
        assertEquals(20, averageAge[0]);
        assertEquals(22, averageAge[1]);
    }
    @Test
    public void noMalesShouldGiveFirstDouble0(){
        Person p1 = new Person("John", 21, "Female");
        Person p2 = new Person("Jane", 22, "Female");
        Person p3 = new Person("Mike", 19, "Female");
        List<Person> persons = Arrays.asList(p1, p2, p3);

        double[] averageAge = Person.averageAgePerGender(persons);
        assertEquals(0, averageAge[0]);
    }
    @Test
    public void noFemalesShouldGiveSecondDouble0(){
        Person p1 = new Person("John", 21, "Male");
        Person p2 = new Person("Jane", 22, "Male");
        Person p3 = new Person("Mike", 19, "Male");
        List<Person> persons = Arrays.asList(p1, p2, p3);

        double[] averageAge = Person.averageAgePerGender(persons);
        assertEquals(0, averageAge[1]);
    }
    @Test
    public void noDatasShouldGive0(){
        List<Person> persons = new ArrayList<>();

        double[] averageAge = Person.averageAgePerGender(persons);
        assertEquals(0, averageAge[0]);
        assertEquals(0, averageAge[1]);
    }
    @Test
    void TestNombre() {
        Person person = new Person("John Doe", 30, "Male");
        assertEquals("John Doe", person.name());
    }


    @Test
    void TestEdad() {
        Person person = new Person("Jane Doe", 25, "Female");
        assertEquals(25, person.age());
    }

    @Test
    void TestGenero() {
        Person person = new Person("John Doe", 30, "Male");
        assertEquals("Male", person.gender());
    }

    @Test
    void name() {
        Person p = new Person("a",15,"Female");
        assertEquals("a", p.name());
    }

    @Test
    void age() {
        Person p = new Person("a",15,"Female");
        assertEquals(15, p.age());
    }

    @Test
    void gender() {
        Person p = new Person("a",15,"Female");
        assertEquals("Female", p.gender());
    }

    @Test
    void averageAgePerGender() {
        Person p1 = new Person("John", 21, "Male");
        Person p2 = new Person("Jane", 22, "Female");
        Person p3 = new Person("Mike", 19, "Male");
        List<Person> persons = Arrays.asList(p1, p2, p3);

        double[] averageAge = Person.averageAgePerGender(persons);
        assertEquals(20, averageAge[0]);
        assertEquals(22, averageAge[1]);
    }
}