package br.com.neoprintlab.AdminPanel.service;

import br.com.neoprintlab.AdminPanel.dto.request.PromptDto;
import br.com.neoprintlab.AdminPanel.dto.response.ApiResponseDto;
import br.com.neoprintlab.AdminPanel.exception.NumberofPromptsExceededException;
import br.com.neoprintlab.AdminPanel.exception.PromptAlreadyExistsException;
import br.com.neoprintlab.AdminPanel.exception.PromptNotFoundException;
import br.com.neoprintlab.AdminPanel.exception.PromptServiceLogicException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface PromptService {
    ResponseEntity<ApiResponseDto<?>> getAllPrompts()
        throws PromptServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> getPromptById(UUID id)
            throws PromptServiceLogicException, PromptNotFoundException;

    ResponseEntity<ApiResponseDto<?>> createPrompt(@Valid PromptDto promptDto)
            throws PromptServiceLogicException, PromptAlreadyExistsException, NumberofPromptsExceededException;

    ResponseEntity<ApiResponseDto<?>> updatePrompt(UUID id, @Valid PromptDto promptDto)
            throws PromptServiceLogicException, PromptNotFoundException;;

    ResponseEntity<ApiResponseDto<?>> deletePrompt(UUID id)
            throws PromptServiceLogicException, PromptNotFoundException;;


}
