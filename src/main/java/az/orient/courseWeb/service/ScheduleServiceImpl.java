package az.orient.courseWeb.service;

import az.orient.courseWeb.dao.ScheduleDao;
import az.orient.courseWeb.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public List<Schedule> getScheduleList() throws Exception {
        return scheduleDao.getScheduleList();
    }
}
