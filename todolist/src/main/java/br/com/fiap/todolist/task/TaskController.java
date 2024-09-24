package br.com.fiap.todolist.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {

    // Injeção de dependências
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String index(Model model) {
        var tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);

        return "index";
    }
}
