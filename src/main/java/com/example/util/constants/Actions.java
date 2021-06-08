package com.example.util.constants;

/**
 * Class with action for servlet.
 */
public final class Actions {
    private Actions(){}

    /** Department actions */
    public static final String ACTION_DEPT_ADD = "/app?action=addDept";
    public static final String ACTION_DEPT_ADD_PAGE = "/app?action=addPageDept";
    public static final String ACTION_DEPT_DELETE = "/app?action=deleteDept";
    public static final String ACTION_DEPT_EDIT = "/app?action=editDept";
    public static final String ACTION_DEPT_EDIT_PAGE = "/app?action=editPageDept";
    public static final String ACTION_DEPT_LIST = "/app?action=listDept";

    /** Employee actions */
    public static final String ACTION_EMPLOYEE_ADD = "/app?action=addEmpl";
    public static final String ACTION_EMPLOYEE_ADD_PAGE = "/app?action=addPageEmpl";
    public static final String ACTION_EMPLOYEE_DELETE = "/app?action=deleteEmpl";
    public static final String ACTION_EMPLOYEE_EDIT  = "/app?action=editEmpl";
    public static final String ACTION_EMPLOYEE_EDIT_PAGE = "/app?action=editPageEmpl";
    public static final String ACTION_EMPLOYEE_LIST  = "/app?action=listEmpl";
}
