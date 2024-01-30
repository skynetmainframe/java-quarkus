package org.example.app.task.dataaccess;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class TaskItemRepositoryTest extends Assertions {

  @Inject
  private TaskItemRepository taskItemRepository;

  @Test
  public void testFindById() {

    // given
    Long itemId = 11L;

    // when
    TaskItemEntity item = this.taskItemRepository.findById(itemId).get();
    // then
    assertThat(item.getTitle()).isEqualTo("Milk");
  }

  // TODO
  public void shouldDeleteTaskItemWhenCallDelete() {

    // given
    Long surfboardId = 35L;
    TaskItemEntity item = this.taskItemRepository.getOne(surfboardId);

    // when
    this.taskItemRepository.delete(item);

    // then
    assertThat(this.taskItemRepository.getOne(surfboardId)).isNull();

  }

  @Test
  // TEMPORARY TO CHECK IF DATABASE IS WORKING CORRECTLY
  public void printAllItems() {

    List<TaskItemEntity> allItems = this.taskItemRepository.findAll();
    System.out.print("Count is: " + allItems.size());
    allItems.forEach(System.out::println);
    System.out.println("Test");

  }

}