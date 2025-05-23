package br.com.neoprintlab.AdminPanel.service;

import br.com.neoprintlab.AdminPanel.dto.request.PromptDto;
import br.com.neoprintlab.AdminPanel.exception.NumberOfPromptsExceededException;
import br.com.neoprintlab.AdminPanel.exception.PromptAlreadyExistsException;
import br.com.neoprintlab.AdminPanel.exception.PromptNotFoundException;
import br.com.neoprintlab.AdminPanel.exception.PromptServiceLogicException;
import br.com.neoprintlab.AdminPanel.model.entity.Prompt;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PromptService {
    List<Prompt> getAllPrompts()
        throws PromptServiceLogicException;

    PromptDto getPromptById(UUID id)
            throws PromptServiceLogicException, PromptNotFoundException;

    Prompt createPrompt(@Valid PromptDto promptDto)
            throws PromptServiceLogicException, PromptAlreadyExistsException, NumberOfPromptsExceededException;

    PromptDto updatePrompt(UUID id, @Valid PromptDto promptDto)
            throws PromptServiceLogicException, PromptNotFoundException;

    Void deletePrompt(UUID id)
            throws PromptServiceLogicException, PromptNotFoundException;


}
