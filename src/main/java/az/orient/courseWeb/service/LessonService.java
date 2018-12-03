package az.orient.courseWeb.service;

import az.orient.courseWeb.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getLessonList() throws Exception;
}
