package az.orient.courseWeb.exception;

public class CourseException extends RuntimeException {

    public CourseException(Integer responseCode, String message){
        super(message);
    }

    public CourseException(String message) {
        super(message);
    }
}
