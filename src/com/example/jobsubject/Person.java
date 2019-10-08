package com.example.jobsubject;

/**
 * @author Administrator
 * @title: Person
 * @projectName JUC-demo
 * @description: TODO
 * @date 2019/9/29 0029下午 5:16
 */
public class Person {

    private Integer id;
    private String personName;

    public Person() {
    }

    public Person(String personName) {
        this.personName = personName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                '}';
    }
}
