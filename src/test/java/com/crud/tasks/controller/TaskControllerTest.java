package com.crud.tasks.controller;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void getTasksTest() throws Exception {
        //Given
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(new TaskDto(1L, "Test test", "Test task controller"));

        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "Test test", "Test task controller"));

        when(service.getAllTasks()).thenReturn(taskList);
        when(taskMapper.mapToTaskDtoList(taskList)).thenReturn(taskDtoList);

        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Test test")))
                .andExpect(jsonPath("$[0].content", is("Test task controller")));;
    }

 @Test
    public void getTaskTest() throws Exception {
        //Given
        Task task = new Task(1L, "Test test", "Test task controller");
        TaskDto taskDto = new TaskDto(1L, "Test test", "Test task controller");

        when(service.getTask(any(Long.class))).thenReturn(Optional.of(task));
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);

        //When & Then
        mockMvc.perform(
                get("/v1/task/getTask")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("taskId", "1"))
                        .andExpect(status().is(200))
                        .andExpect(jsonPath("$.id", is(1)))
                        .andExpect(jsonPath("$.title", is(taskDto.getTitle())))
                        .andExpect(jsonPath("$.content", is(taskDto.getContent())));
    }

    @Test
    public void deleteTaskTest() throws Exception {
        //Given
        Task task = new Task(1L, "Test test", "Test task controller");
        TaskDto taskDto = new TaskDto(1L, "Test test", "Test task controller");

        doNothing().when(service).deleteTask(any(Long.class));

        //When & Then
        mockMvc.perform(delete("/v1/task/deleteTask")
                .contentType(MediaType.APPLICATION_JSON)
                .param("taskId", "1"))
                .andExpect(status().is(200));
    }

    @Test
    public void updateTaskTest() throws Exception {
        //Given
        TaskDto updatedTask = new TaskDto(1L, "Task - test update", "Update test");
        Task task = new Task(1L, "Update", "Update test task");

        when(taskMapper.mapToTask((ArgumentMatchers.any(TaskDto.class)))).thenReturn(task);
        when(service.saveTask((ArgumentMatchers.any(Task.class)))).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(updatedTask);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(updatedTask);

        //When & Then
        mockMvc.perform(put("/v1/task/updateTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Task - test update")))
                .andExpect(jsonPath("$.content", is("Update test")));
    }

    @Test
    public void createTaskTest() throws Exception {
        //Given
        Task task = new Task(2L, "Test3", "Test- task to be added");
        TaskDto taskDto = new TaskDto(3L, "Test", "task to be added");

        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(service.saveTask(task)).thenReturn(task);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(post("/v1/task/createTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));
    }
}