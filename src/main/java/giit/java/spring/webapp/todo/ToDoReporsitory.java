package giit.java.spring.webapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ToDoReporsitory extends JpaRepository<ToDo, Integer> {

}
