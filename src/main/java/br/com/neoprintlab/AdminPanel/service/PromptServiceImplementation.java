package br.com.neoprintlab.AdminPanel.service;

import br.com.neoprintlab.AdminPanel.dto.request.PromptDto;
import br.com.neoprintlab.AdminPanel.dto.response.ApiResponseDto;
import br.com.neoprintlab.AdminPanel.dto.response.ApiResponseStatus;
import br.com.neoprintlab.AdminPanel.exception.NumberofPromptsExceededException;
import br.com.neoprintlab.AdminPanel.exception.PromptAlreadyExistsException;
import br.com.neoprintlab.AdminPanel.exception.PromptNotFoundException;
import br.com.neoprintlab.AdminPanel.exception.PromptServiceLogicException;
import br.com.neoprintlab.AdminPanel.model.entity.Prompt;
import br.com.neoprintlab.AdminPanel.repository.PromptRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class PromptServiceImplementation implements PromptService {

    @Autowired
    PromptRepository promptRepository;

    @Override
    public ResponseEntity<ApiResponseDto<?>> getAllPrompts() throws PromptServiceLogicException {
        List<Prompt> prompts = promptRepository.findByActiveTrue();
        System.out.println(prompts);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponseDto<>(ApiResponseStatus.SUCCESS.name(), prompts));
    }

    @Override
    public ResponseEntity<ApiResponseDto<?>> getPromptById(UUID id) throws PromptServiceLogicException, PromptNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDto<?>> createPrompt(@Valid PromptDto promptDto) throws PromptServiceLogicException, PromptAlreadyExistsException, NumberofPromptsExceededException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDto<?>> updatePrompt(UUID id, PromptDto promptDto) throws PromptServiceLogicException, PromptNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDto<?>> deletePrompt(UUID id) throws PromptServiceLogicException, PromptNotFoundException {
        return null;
    }
}
