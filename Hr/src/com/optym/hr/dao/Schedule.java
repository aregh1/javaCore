package com.optym.hr.dao;

import java.util.Date;

/**
 * Created by Areg on 7/8/2017.
 */
public interface Schedule {
    void addSchedule(Schedule schedule);
    Schedule getSchedule(int id);
    void deleteSchedule(int id);
    void changeTime(int id, Date date);
}
