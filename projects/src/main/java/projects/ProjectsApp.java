package projects;

import projects.dao.DbConnection;import projects.exception.DbException;

import java.sql.Connection;

public class ProjectsApp {

 public static void main(String[] args) {


  Connection conn = DbConnection.getConnection();
 }
}
