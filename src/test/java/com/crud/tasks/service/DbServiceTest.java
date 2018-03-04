package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import javafx.beans.binding.When;
import javassist.bytecode.annotation.LongMemberValue;
import org.hibernate.internal.util.collections.EmptyIterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.CompositeIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository repository;

    @Test
    public void getAllTasks(){
        //Given
        Task task1 = new Task(1L, "test1", "abc");
        Task task2 = new Task(2L, "test2", "xyz");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        when(repository.findAll()).thenReturn(taskList);

        //When
        List<Task> resultTaskList = repository.findAll();

        //Then
        assertEquals(taskList.size(), resultTaskList.size());
    }
    @Test
    public void findAllById (){
        //Given
        Optional <Task> task = Optional.of(new Task (5L, "abc", "pol"));
        when(repository.findAllById(any(Long.class))).thenReturn(task);

        //When
        Optional<Task> taskOptional = repository.findAllById(5L);

        //Then
        assertEquals(task, taskOptional);
    }
    @Test
    public void saveTask(){
        //Given
        Task task1 = new Task(1L, "test1", "abc");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);

        //When
        when(repository.save(task1)).thenReturn(task1);

        Task result = repository.save(task1);

        //Then
        assertEquals(1,taskList.size());
    }
    @Test
    public void shouldDelete() {
        //when
        dbService.deleteTask(ArgumentMatchers.anyLong());
        //then
        verify(repository, times(1)).deleteById(ArgumentMatchers.anyLong());
    }

}