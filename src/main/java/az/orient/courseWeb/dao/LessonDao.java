package az.orient.courseWeb.dao;

import az.orient.courseWeb.model.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getLessonList() throws Exception;
}
