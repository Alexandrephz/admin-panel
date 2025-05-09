package br.com.neoprintlab.AdminPanel.service;

import br.com.neoprintlab.AdminPanel.dto.PromptDto;
import br.com.neoprintlab.AdminPanel.model.entity.Prompt;
import br.com.neoprintlab.AdminPanel.repository.PromptRepository;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromptService {
    @Autowired
    private PromptRepository promptRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public List<Prompt> getActivePrompts() {
        return promptRepository.findByActiveTrue();
    }

    public List<Prompt> getPromptsByCategory(String category) {
        return promptRepository.findByCategoryAndActiveTrue(category);
    }

    public List<Prompt> getAllPrompts() {
        return promptRepository.findAll();
    }

    public Prompt getPromptById(UUID id) {
        return promptRepository.getReferenceById(id);
    }

    public Prompt createPrompt(@Valid PromptDto promptDto) {
        Prompt newPrompt = new Prompt(promptDto);
        promptRepository.save(newPrompt);
        return newPrompt;
    }

    public Prompt updatePrompt(UUID id, @Valid PromptDto promptDto) throws JsonMappingException {
        Prompt prompt = promptRepository.getReferenceById(id);
        objectMapper.updateValue(prompt, promptDto);
        promptRepository.save(prompt);
        return prompt;
    }

    public void deletePrompt(UUID id) {
    }
}
