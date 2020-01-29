package giit.java.spring.webapp.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
class ToDoServlet {
    private final Logger logger = LoggerFactory.getLogger(ToDoServlet.class);

    private ToDoReporsitory reporsitory;

    ToDoServlet(ToDoReporsitory reporsitory) {
        this.reporsitory = reporsitory;
    }

    @GetMapping
    ResponseEntity<List<ToDo>> findAllTodos() {
        logger.info("Got request");
        return ResponseEntity.ok(reporsitory.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<ToDo> toggleTodo(@PathVariable("id") Integer id) {
        Optional<ToDo> todo = reporsitory.findById(id);
        todo.ifPresent(t -> {
            t.setDone(!t.isDone());
            reporsitory.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<ToDo> saveTodos(@RequestBody ToDo todo) {
        return ResponseEntity.ok(reporsitory.save(todo));
    }
}
