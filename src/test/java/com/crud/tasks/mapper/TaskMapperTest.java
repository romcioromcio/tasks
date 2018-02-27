package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.domain.TrelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        Task task = new Task(1L, "Test test1", "Test:_Map_to_task");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, taskDto.getId().longValue());
        assertEquals("Test test1", taskDto.getTitle());
        assertEquals("Test:_Map_to_task", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L,"Test test1","Test:_Map_to_taskDto");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, task.getId().longValue());
        assertEquals("Test test1", task.getTitle());
        assertEquals("Test:_Map_to_taskDto", task.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task = new Task(1L,"Test test1","Test:_Map_to_taskDto");
        taskList.add(task);

        //When
        List<TaskDto> mappedListTask = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(1, mappedListTask.size());
    }
}