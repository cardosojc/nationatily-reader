package io.nationatily.domain;

public class Person {
    private String name;
    private String nationality;
    private String country;

    public Person(String name, String nationality, String country) {
        this.name = name;
        this.nationality = nationality;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
