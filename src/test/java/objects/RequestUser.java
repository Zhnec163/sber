package objects;

import lombok.Data;

import java.util.ArrayList;

@Data
public class RequestUser {
    private String email;
    private String name;
    private ArrayList<Integer> tasks;
    private ArrayList<Integer> companies;
    private String hobby;
    private String adres;
    private String name1;
    private String surname1;
    private String fathername1;
    private String cat;
    private String dog;
    private String parrot;
    private String cavy;
    private String hamster;
    private String squirrel;
    private String phone;
    private String inn;
    private String gender;
    private String birthday;
    private String date_start;
}
