package br.com.neoprintlab.AdminPanel.controller;

import br.com.neoprintlab.AdminPanel.dto.response.ApiResponseDto;
import br.com.neoprintlab.AdminPanel.exception.PromptServiceLogicException;
import br.com.neoprintlab.AdminPanel.model.entity.Prompt;
import br.com.neoprintlab.AdminPanel.service.PromptService;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.neoprintlab.AdminPanel.dto.request.PromptDto;

import java.util.UUID;

@RestController
@RequestMapping("/prompts")
@RequiredArgsConstructor
@Tag(name = "Prompts", description = "APIs for managing AI generation prompts")
public class PromptController {

    @Autowired
    private PromptService promptService;

    @GetMapping
    @Operation(summary = "Get all prompts")
    public ResponseEntity<ApiResponseDto<?>> getAllPrompts(
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) String category)
            throws PromptServiceLogicException
    {
        return promptService.getAllPrompts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get prompt by ID")
    public ResponseEntity<ApiResponseDto<?>> getPromptById(@PathVariable UUID id) {
        return promptService.getPromptById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new prompt")
    public ResponseEntity<ApiResponseDto<?>> createPrompt(@Valid @RequestBody PromptDto promptDto) {
        return promptService.createPrompt(promptDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing prompt")
    public ResponseEntity<ApiResponseDto<?>> updatePrompt(
            @PathVariable UUID id,
            @Valid @RequestBody PromptDto promptDto) throws JsonMappingException {
        return promptService.updatePrompt(id, promptDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a prompt")
    public ResponseEntity<ApiResponseDto<?>> deletePrompt(@PathVariable UUID id) {
        return promptService.deletePrompt(id);
    }
}
