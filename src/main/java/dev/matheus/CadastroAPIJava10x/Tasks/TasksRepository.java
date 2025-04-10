package dev.matheus.CadastroAPIJava10x.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TasksModel, Long> {
}
