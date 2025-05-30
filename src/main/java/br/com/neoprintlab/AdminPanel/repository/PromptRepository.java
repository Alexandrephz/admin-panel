package br.com.neoprintlab.AdminPanel.repository;

import br.com.neoprintlab.AdminPanel.model.entity.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Long> {

    List<Prompt> findByActiveTrue();
    Long countByActiveTrue();
}
