package az.orient.courseWeb.dao;

import az.orient.courseWeb.model.Schedule;

import java.util.List;

public interface ScheduleDao {

    List<Schedule> getScheduleList() throws Exception;
}
