package br.com.fiap.todolist.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;




@Controller
public class TaskController {

    // Injeção de dependências
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    // GET PÁGINA INDEX
    @GetMapping
    public String index(Model model) {
        var tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);

        return "index";
    }


    // GET PÁGINA FORMS
    @GetMapping("/form")
    public String form(Task task) {
        
        return "form";
    }


    // POST TASKS 
    @PostMapping("/task")
    public String create(@Valid Task task, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) return "form";

        taskService.create(task);
        redirectAttributes.addFlashAttribute("message", "Tarefa cadastrada com sucesso.");
        return "redirect:/"; //redireciona pra página index
    }
    
    
}
