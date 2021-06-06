package com.example.util.constants;

/**
 * Class with sql-queries to database.
 */
public final class QueriesSql {
    private QueriesSql(){}

    /** EMPLOYEE */
    public static final String SQL_COUNT_ROW_EMPLOYEE = "SELECT count(*) FROM employee";
    public static final String SQL_CREATE_EMPLOYEE = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";

    public static final String SQL_UPDATE_EMPLOYEE = "UPDATE employee SET employee_name=?, employee_birth=?, " +
            "employee_email=?, employee_years_working=?, dept_id=? WHERE employee_id=?";

    public static final String SQL_DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_id=?";
    public static final String SQL_DELETE_EMPLOYEES_FROM_DEPARTMENT = "DELETE FROM employee WHERE dept_id=?";

    public static final String SQL_ALL_EMPLOYEE_FROM_DEPARTMENT = "SELECT * FROM employee WHERE dept_id=?";
    public static final String SQL_ALL_EMPLOYEE = "SELECT * FROM employee";

    public static final String SQL_EMPLOYEE_EMAIL = "SELECT count(*) FROM employee WHERE employee_email=?";

    /** DEPARTMENT */
    public static final String SQL_COUNT_ROW_DEPARTMENT = "SELECT count(*) FROM dept";
    public static final String SQL_CREATE_DEPARTMENT = "INSERT INTO dept VALUES (?, ?, ?)";

    public static final String SQL_UPDATE_DEPARTMENT = "UPDATE dept SET dept_name=?, dept_phone_number=? WHERE dept_id=?";

    public static final String SQL_DELETE_DEPARTMENT = "DELETE FROM dept WHERE dept_id=?";

    public static final String SQL_ALL_DEPARTMENT = "SELECT * FROM dept";

    public static final String SQL_DEPARTMENT_NAME = "SELECT count(*) FROM dept WHERE dept_name=?";
}
