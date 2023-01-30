package org.example;


@JsonSerializable
public class MyObject {

    @IgnoreNull
    public String name;
    @JsonElement(name = "mySurname")
    public String surname;

    @JsonElement
    public String info;


    public MyObject(String name, String surname, String info) {
        this.name = name;
        this.surname = surname;
        this.info = info;
    }
}
