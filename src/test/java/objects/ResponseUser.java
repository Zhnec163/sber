package objects;

import lombok.Data;

import java.util.ArrayList;
@Data
public class ResponseUser {
    private String email;
    private String name;
    private String name1;
    private String hobby;
    private String surname1;
    private String fathername1;
    private String cat;
    private String dog;
    private String parrot;
    private String cavy;
    private String hamster;
    private String squirrel;
    private String phone;
    private String adres;
    private String gender;
    private String inn;
    private DateStart date_start;
    private DateUpdated date_updated;
    private Birthday birthday;
    private ArrayList<String> role;
    private DateRegister date_register;
    private String date;
    private String by_user;
    private ArrayList<Company> companies;
    private ArrayList<Task> tasks;

    @Data
    public static class DateStart{
        public Integer sec;
        public Integer usec;
    }

    @Data
    public static class DateUpdated{
        public Integer sec;
        public Integer usec;
    }

    @Data
    public static class DateRegister{
        public Integer sec;
        public Integer usec;
    }

    @Data
    public static class Birthday{
        public Integer sec;
        public Integer usec;
    }

    @Data
    public static class Company{
        public String name;
        public Integer id;
    }

    @Data
    public static class Task{
        public String name;
        public Integer id;
    }
}