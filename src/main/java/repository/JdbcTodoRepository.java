package repository;
import db.MySQLConnectionFactory;
import model.Todo;
import model.TodoFilter;
import model.User;
import mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTodoRepository {
    @Override
    public void save(Todo todo) {
        Connection connection = null;
        try {
            connection = MySQLConnectionFactory.getConnection();
            String sql = "insert into todos(position, name, completed,) values(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, todo.getPosition());
            ps.setString(2, todo.getName());
            ps.setString(3, todo.getEmail());
            ps.setBoolean(4, todo.isCompleted());
            int rowCount = ps.executeUpdate();
            if (rowCount == 1)
                System.out.print("New Todo inserted into database");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(String name, String email, String position) {
        Connection connection = null;
        try {
            connection = MySQLConnectionFactory.getConnection();
            String sql = "update todos set completed=? where position=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, position);
            ps.setString(2, name);
            ps.setString(3, email);
            // ps.setBoolean(4, todo.isCompleted());
            int rowCount = ps.executeUpdate();
            if (rowCount == 1)
                System.out.print("Todo updated database");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void update(String name, String position) {
        Connection connection = null;
        try {
            connection = MySQLConnectionFactory.getConnection();
            String sql = "update todos set position=? where name=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, position);
            //ps.setString(3, todo.getEmail());
            //ps.setBoolean(4, todo.isCompleted());

            int rowCount = ps.executeUpdate();
            if (rowCount == 1) {
                System.out.println("Todo has been updated");
            }
        }
        //ResultSet rs = ps.executeQuery();
        // if (rowCount == 1)
        //System.out.print("New Todo inserted into database");
        // while (rs.next()) {
        //   Todo todo = new Todo();
        // todo.setName(rs.getString("name"));
        // todo.setPosition(rs.getString("position"));
        // todo.setCompleted(rs.getBoolean(("completed")));
        //todo.add(todo);
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void delete(String position) {

        Connection connection = null;
        try {
            connection = MySQLConnectionFactory.getConnection();
            String sql = "update todos set position=? where name=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            // ps.setString(1, name);
            ps.setString(1, position);
            //ps.setString(3, todo.getEmail());
            //ps.setBoolean(4, todo.isCompleted());

            int rowCount = ps.executeUpdate();
            if (rowCount == 1) {
                System.out.println("Todo has been updated");
            }
        }
        //ResultSet rs = ps.executeQuery();
        // if (rowCount == 1)
        //System.out.print("New Todo inserted into database");
        // while (rs.next()) {
        //   Todo todo = new Todo();
        // todo.setName(rs.getString("name"));
        // todo.setPosition(rs.getString("position"));
        // todo.setCompleted(rs.getBoolean(("completed")));
        //todo.add(todo);
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<Todo> todos = new ArrayList<>();
    Connection connection = null;
        try{
        connection = MySQLConnectionFactory.getConnection();
        String sql = "select * from todos where name=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name);
        //ps.setString(2, position);
        //ps.setString(3, todo.getEmail());
        //ps.setBoolean(4, todo.isCompleted());

        // int rowCount = ps.executeUpdate();
        // if (rowCount == 1)
        //{
        //  System.out.println("Todo has been updated");
        //}

        ResultSet rs = ps.executeQuery();
        // if (rowCount == 1)
        //System.out.print("New Todo inserted into database");
        while (rs.next()) {
            Todo todo = new Todo();
            todo.setName(rs.getString("name"));
            todo.setPosition(rs.getString("position"));
            todo.setCompleted(rs.getBoolean(("completed")));
            todos.add(todo);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }finally{
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return todos;
    }

 }



