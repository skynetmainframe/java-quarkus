package org.example.app.task.logic;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.domain.TaskItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Use-Case to delete {@link org.example.app.task.common.TaskItem}s.
 */
@Named
@Transactional
public class UcDeleteTaskItem {

  private static final Logger LOG = LoggerFactory.getLogger(UcDeleteTaskItem.class);

  @Inject
  TaskItemRepository taskItemRepository;

  /**
   * @param id the {@link org.example.app.task.domain.TaskListEntity#getId() primary key} of the
   *        {@link org.example.app.task.domain.TaskListEntity} to delete.
   */
  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_TASK_ITEM)
  public void delete(Long id) {

    this.taskItemRepository.deleteById(id);
  }

  /**
   * @param item the {@link TaskItemEto} to delete.
   */
  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_TASK_ITEM)
  public void delete(TaskItemEto item) {

    Long id = item.getId();
    if (id == null) {
      LOG.info("TaskItem {} ist transient und kann nicht gelöscht werden", item.getTitle());
    }
    this.taskItemRepository.deleteById(id);
  }

}