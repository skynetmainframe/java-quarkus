package org.example.app.task.dataaccess;

import java.time.LocalDateTime;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TASK_ITEM")
public class TaskItemEntity extends ApplicationPersistenceEntity {

  @ManyToOne(targetEntity = TaskListEntity.class)
  // @JoinColumn(name = "LIST_ID")
  private TaskListEntity taskListEntity;

  public TaskListEntity getTaskListEntity() {

    return this.taskListEntity;
  }

  public void setTaskListEntity(TaskListEntity taskListEntity) {

    this.taskListEntity = taskListEntity;
  }

  public String getTitle() {

    return this.title;
  }

  public void setTitle(String title) {

    this.title = title;
  }

  public boolean isCompleted() {

    return this.completed;
  }

  public void setCompleted(boolean completed) {

    this.completed = completed;
  }

  public boolean isStarred() {

    return this.starred;
  }

  public void setStarred(boolean starred) {

    this.starred = starred;
  }

  public LocalDateTime getDeadline() {

    return this.deadline;
  }

  public void setDeadline(LocalDateTime deadline) {

    this.deadline = deadline;
  }

  @Column(name = "TITLE")
  private String title;

  @Column(name = "COMPLETED")
  private boolean completed;

  @Column(name = "STARRED")
  private boolean starred;

  @Column(name = "DEADLINE")
  private LocalDateTime deadline;

}
