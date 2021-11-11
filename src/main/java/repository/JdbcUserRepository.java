package repository;
import db.MySQLConnectionFactory;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserRepository implements UserRepository {
    @Override
    public void save(User user) {
        User user = null;
        Connection connection = null;
        try {
            connection = MySQLConnectionFactory.getConnection();
            String sql = "insert into users(name, email, password) values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
        }catch(SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
@Override
public User findbyEmail(String email){
    User user = null;
    Connection connection = null;
    try {
        connection = MySQLConnectionFactory.getConnection();
        String sql = "select * from users where email=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(3, todo.getEmail("email"));
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ps.setString(1, user.getString("position"));
            ps.setString(2, user.getString("name"));
            ps.setString(3, user.getString("email"));
            ps.setBoolean(4, user.getString("password"));
        }
    }catch (SQLException e) {
        e.printStackTrace();
    }finally{
        if connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    return user;
}
}