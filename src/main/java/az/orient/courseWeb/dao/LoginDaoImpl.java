package az.orient.courseWeb.dao;

import az.orient.courseWeb.model.Action;
import az.orient.courseWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class LoginDaoImpl implements LoginDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public User getUserDetailsByUsername(String username) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        User user = null;
        String sql = "SELECT u.*, r.role_name FROM user u \n" +
                "LEFT JOIN role r ON u.role_id = r.id_role WHERE u.active = 1 and u.username = ?";
        try {
            user = (User) jdbcTemplate.queryForObject(sql, new Object[] {username}, new BeanPropertyRowMapper(User.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Action> getActionListByRole(String role) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Action> actionList = null;
        String sql = "SELECT a.id_action, a.action_name, r.role_name FROM action a INNER JOIN role_action ra ON a.id_action = ra.action_id \n" +
                    "INNER JOIN role r ON ra.role_id = r.id_role WHERE a.active AND r.role_name = ?";
        try {
            actionList = jdbcTemplate.query(sql, new Object[] {role}, new BeanPropertyRowMapper(Action.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return actionList;
    }
}
