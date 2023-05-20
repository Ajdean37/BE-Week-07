package projects.service;

import projects.dao.DbConnection;
import projects.entity.Project;
import projects.dao.ProjectDao;
import projects.exception.DbException;

import javax.swing.plaf.OptionPaneUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProjectService {
 private ProjectDao projectDao = new ProjectDao();

 public Project addProject(Project project) {
  return projectDao.insertProject(project);

 }

 public List<Project> fetchAllProjects() {
  return projectDao.fetchAllProjects();
 }

 public Project fetchProjectById(Integer projectId) {
  return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException("Project with project " +
    "ID= " + projectId + " does not exist."));
 }

 public void modifyProjectDetails(Project project) {
  if (!projectDao.modifyProjectDetails(project)) {
   throw new DbException("Project with ID=" + project.getProjectId() + " does not exist.");
  }
 }

 public void deleteProject(Integer projectId) {
  if (!projectDao.deleteProject(projectId)) {
   throw new DbException("Project with ID=" + projectId + " does not exist.");
  }
 }
}
