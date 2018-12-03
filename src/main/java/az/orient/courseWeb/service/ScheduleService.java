package az.orient.courseWeb.service;

import az.orient.courseWeb.model.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getScheduleList() throws Exception;
}
