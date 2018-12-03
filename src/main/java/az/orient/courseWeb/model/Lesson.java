package az.orient.courseWeb.model;

public class Lesson {

    private int id_lesson, lesson_time, active;
    private String lesson_name;
    private double lesson_price;

    public int getId_lesson() {
        return id_lesson;
    }

    public void setId_lesson(int id_lesson) {
        this.id_lesson = id_lesson;
    }

    public int getLesson_time() {
        return lesson_time;
    }

    public void setLesson_time(int lesson_time) {
        this.lesson_time = lesson_time;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public double getLesson_price() {
        return lesson_price;
    }

    public void setLesson_price(double lesson_price) {
        this.lesson_price = lesson_price;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id_lesson=" + id_lesson +
                ", lesson_time=" + lesson_time +
                ", active=" + active +
                ", lesson_name='" + lesson_name + '\'' +
                ", lesson_price=" + lesson_price +
                '}';
    }
}
