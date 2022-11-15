package org.example.app.task.logic;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.app.task.common.TaskListEto;
import org.example.app.task.dataaccess.TaskListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Use-Case to delete {@link org.example.app.task.common.TaskList}s.
 */
@Named
@Transactional
public class UcDeleteTaskList {

  private static final Logger LOG = LoggerFactory.getLogger(UcDeleteTaskList.class);

  @Inject
  TaskListRepository taskListRepository;

  /**
   * @param id the {@link org.example.app.task.dataaccess.TaskListEntity#getId() primary key} of the
   *        {@link org.example.app.task.dataaccess.TaskListEntity} to delete.
   */
  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_TASK_ITEM)
  public void delete(Long id) {

    this.taskListRepository.deleteById(id);
  }

  /**
   * @param list the {@link TaskListEto} to delete.
   */
  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_TASK_ITEM)
  public void delete(TaskListEto list) {

    Long id = list.getId();
    if (id == null) {
      LOG.info("TaskItem {} ist transient und kann nicht gelöscht werden", list.getTitle());
    }
    this.taskListRepository.deleteById(id);
  }

}