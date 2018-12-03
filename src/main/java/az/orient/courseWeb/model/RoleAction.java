package az.orient.courseWeb.model;

public class RoleAction {

    private long id_role_action;
    private Role role;
    private Action action;
    private int active;

    public long getId_role_action() {
        return id_role_action;
    }

    public void setId_role_action(long id_role_action) {
        this.id_role_action = id_role_action;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "RoleAction{" +
                "id_role_action=" + id_role_action +
                ", role=" + role +
                ", action=" + action +
                ", active=" + active +
                '}';
    }
}
