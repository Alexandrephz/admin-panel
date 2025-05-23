package br.com.neoprintlab.AdminPanel.service;

import br.com.neoprintlab.AdminPanel.dto.request.PromptDto;
import br.com.neoprintlab.AdminPanel.exception.NumberOfPromptsExceededException;
import br.com.neoprintlab.AdminPanel.exception.PromptAlreadyExistsException;
import br.com.neoprintlab.AdminPanel.exception.PromptNotFoundException;
import br.com.neoprintlab.AdminPanel.exception.PromptServiceLogicException;
import br.com.neoprintlab.AdminPanel.mapper.PromptMapper;
import br.com.neoprintlab.AdminPanel.model.entity.Prompt;
import br.com.neoprintlab.AdminPanel.repository.PromptRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class PromptServiceImpl implements PromptService {

    @Autowired
    PromptRepository promptRepository;

    private final PromptMapper promptMapper;

    public PromptServiceImpl(PromptMapper promptMapper) {
        this.promptMapper = promptMapper;
    }

    @Override
    @Transactional
    public List<Prompt> getAllPrompts() throws PromptServiceLogicException {
        return promptRepository.findByActiveTrue();
    }

    @Override
    public PromptDto getPromptById(UUID id) throws PromptServiceLogicException, PromptNotFoundException {
        return null;
    }

    @Override
    public Prompt createPrompt(PromptDto promptDto) throws PromptServiceLogicException, PromptAlreadyExistsException, NumberOfPromptsExceededException {
        // Check if limit is reached
        long activePromptCount = promptRepository.countByActiveTrue();

        if (activePromptCount >= 8) {
            throw new NumberOfPromptsExceededException("Maximum number of active prompts (8) reached");
        }

        // Create and save the prompt
        Prompt prompt = promptMapper.toEntity(promptDto);
        prompt.setActive(true); // Ensure it's set as active

        return promptRepository.save(prompt);
    }

    @Override
    public PromptDto updatePrompt(UUID id, PromptDto promptDto) throws PromptServiceLogicException, PromptNotFoundException {
        return null;
    }

    @Override
    public Void deletePrompt(UUID id) throws PromptServiceLogicException, PromptNotFoundException {
        return null;
    }
}
