package model;
import java.util.Objects;

    //Object model
public class Todo {
    private String name;
    private String position;
    private String email;
    private boolean completed;

    private User user;

    //Constructor
        public Todo() {

        }
        public Todo(String position){
            this.position = position;
        }
        public Todo(String name, String position, String email, boolean completed){
            this.name = name;
            this.position= position;
            this.email = email;
            this.completed = completed;
        }
        //accessor methods
        public String getName(){
            return name;
        }
        public void setName(){
            this.name = name;
        }
        public String getPosition(){
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isCompleted(){
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
        @Override
        public String toString(){
            return "Todo{" + "name=" + ", position='" + position + '\'' + ", email=" + email +" completed=" + completed +'}';
        }
        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Todo todo = (Todo) o;
            return name == todo.name && completed == todo.completed && Objects.equals(email, todo.email);
        }
        @Override
        public int hashCode(){
         return Objects.hash(name, position, email, completed);
        }
    }
