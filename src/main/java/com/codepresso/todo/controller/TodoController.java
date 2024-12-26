package com.codepresso.todo.controller;

import java.util.List;

import com.codepresso.todo.service.TodoService;
import com.codepresso.todo.vo.ResultDto;
import com.codepresso.todo.vo.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TodoController {

    //todo TodoService를 활용하기 위해 의존성 주입 코드를 작성하세요
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    //todo API문서를 확인하여 GET /todo REST API를 완성하세요
    //todo TodoService를 활용하세요
    @GetMapping("/todo")
    public List<Todo> getTodoList(){
        List<Todo> list = todoService.getTodoList();
        return list;
    }

    //todo API문서를 확인하여 POST /todo REST API를 완성하세요
    //todo TodoService를 활용하세요
    @PostMapping(value = "/todo")
    public ResultDto addTodo(@RequestBody Todo todoParam) {
        Todo todo = new Todo(todoParam.getContent());
        todoService.addTodo(todo);


        //todo return code는 변경하지 마세요
        return new ResultDto(200, "Success");
    }

    //todo API문서를 확인하여 DELETE /todo REST API를 완성하세요
    //todo TodoService를 활용하세요
    @DeleteMapping("/todo/{id}")
    public ResultDto deleteTodo(@PathVariable("id") String id) {
        todoService.deleteTodo(Integer.parseInt(id));
        //todo return code는 변경하지 마세요
        return new ResultDto(200, "Success");
    }

}
