package az.orient.courseWeb.model;

public class Action {

    private long id_action;
    private String action_name, role_name;
    private int active;

    public long getId_action() {
        return id_action;
    }

    public void setId_action(long id_action) {
        this.id_action = id_action;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id_action=" + id_action +
                ", action_name='" + action_name + '\'' +
                ", role_name='" + role_name + '\'' +
                ", active=" + active +
                '}';
    }
}
