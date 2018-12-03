package az.orient.courseWeb.service;

import az.orient.courseWeb.dao.LoginDao;
import az.orient.courseWeb.model.Action;
import az.orient.courseWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public User getUserDetailsByUsername(String username) throws Exception {
        return loginDao.getUserDetailsByUsername(username);
    }

    @Override
    public List<Action> getActionListByRole(String role) throws Exception {
        return loginDao.getActionListByRole(role);
    }
}
