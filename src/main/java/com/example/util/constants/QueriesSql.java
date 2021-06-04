package com.example.util.constants;

/**
 * Class with sql-queries to database.
 */
public final class QueriesSql {
    private QueriesSql(){}

    /** EMPLOYEE */
    private static final String SQL_COUNT_ROW_EMPLOYEE = "SELECT count(*) FROM employee";
    private static final String SQL_CREATE_EMPLOYEE= "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_SET_EMPLOYEE = "UPDATE employee SET ";
    private static final String SQL_UPDATE_WHERE_EMPLOYEE = " WHERE employee_email=?";

    private static final String SQL_DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_email=?";
    private static final String SQL_DELETE_EMPLOYEES_FROM_DEPARTMENT = "DELETE FROM employee WHERE dept_name=?";

    private static final String SQL_ALL_EMPLOYEE_FROM_DEPARTMENT = "SELECT * FROM employee WHERE dept_name=?";

    /** DEPARTMENT */
    private static final String SQL_COUNT_ROW_DEPARTMENT = "SELECT count(*) FROM dept";
    private static final String SQL_CREATE_DEPARTMENT = "INSERT INTO dept VALUES (?, ?)";

    private static final String SQL_UPDATE_SET_DEPARTMENT = "UPDATE dept SET ";
    private static final String SQL_UPDATE_WHERE_DEPARTMENT = " WHERE dept_name=?";

    private static final String SQL_DELETE_DEPARTMENT = "DELETE FROM dept WHERE dept_name=?";

    private static final String SQL_ALL_DEPARTMENT = "SELECT * FROM dept";

}