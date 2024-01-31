package org.example.app.task.dataaccess;

import java.util.List;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TASK_LIST")
public class TaskListEntity extends ApplicationPersistenceEntity {

  @OneToMany(mappedBy = "taskListEntity")
  private List<TaskItemEntity> taskItemList;

  public List<TaskItemEntity> getTaskItemList() {

    return this.taskItemList;
  }

  public void setTaskItemList(List<TaskItemEntity> taskItemList) {

    this.taskItemList = taskItemList;
  }

  @Column(name = "TITLE")
  private String title;

  public String getTitle() {

    return this.title;
  }

  public void setTitle(String title) {

    this.title = title;
  }

}
