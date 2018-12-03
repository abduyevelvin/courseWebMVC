package az.orient.courseWeb.service;

import az.orient.courseWeb.model.Action;
import az.orient.courseWeb.model.User;

import java.util.List;

public interface LoginService {

    User getUserDetailsByUsername(String username) throws Exception;
    List<Action> getActionListByRole(String role) throws Exception;
}
