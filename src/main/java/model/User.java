package model;

import java.util.List;

public class User {
    private String name;
    private String position;
    private String email;
    private String password;

    private List<Todo> todos;
      public String getName(){
          return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPosition(){
          return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    @Override
    public String toString(){
          return "User{" + "name='" + name + '\'' + "email=" + email + '\'' +'}';
    }
}
