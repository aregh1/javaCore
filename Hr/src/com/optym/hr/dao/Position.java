package com.optym.hr.dao;

/**
 * Created by Areg on 7/8/2017.
 */
public interface Position {
    void deletePosition(Position position);
    Position[] seeEmployeesByPosition(Position position);
}
