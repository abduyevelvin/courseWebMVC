package az.orient.courseWeb.model;

public class Role {

    private long id_role;
    private String role_name;
    private int active;

    public long getId_role() {
        return id_role;
    }

    public void setId_role(long id_role) {
        this.id_role = id_role;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_role=" + id_role +
                ", role_name='" + role_name + '\'' +
                ", active=" + active +
                '}';
    }
}
