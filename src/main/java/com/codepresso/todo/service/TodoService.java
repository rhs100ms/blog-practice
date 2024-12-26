package com.codepresso.todo.service;

import java.util.List;

import com.codepresso.todo.vo.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final List<Todo> todoList;

    public TodoService(List<Todo> todoList) {
        this.todoList = todoList;
    }



    //todo 멤버 변수 todoList에 의존성 주입을 하기 위한 코드를 완성하세요

    public void addTodo(Todo todo) {
        //todo todoList에 새로운 항목을 추가하세요
        todo.setId(todoList.size());
        todoList.add(todo);
    }

    public List<Todo> getTodoList(){
        //todo todoList 정보들을 반환 하세요

        return todoList;
    }

    public void deleteTodo(int index) {
        //todo todoList에서 index에 해당하는 항목을 삭제하세요
        todoList.remove(index);
    }
}
