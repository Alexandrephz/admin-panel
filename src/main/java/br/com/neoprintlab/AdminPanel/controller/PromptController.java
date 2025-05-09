package br.com.neoprintlab.AdminPanel.controller;

import br.com.neoprintlab.AdminPanel.model.entity.Prompt;
import br.com.neoprintlab.AdminPanel.service.PromptService;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.neoprintlab.AdminPanel.dto.PromptDto;

import java.util.List;
import java.util.Optional;
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
    public ResponseEntity<List<Prompt>> getAllPrompts(
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) String category) {

        List<Prompt> prompts;
        if (active != null && active) {
            prompts = promptService.getActivePrompts();
        } else if (category != null && !category.isEmpty()) {
            prompts = promptService.getPromptsByCategory(category);
        } else {
            prompts = promptService.getAllPrompts();
        }

        return ResponseEntity.ok(prompts);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get prompt by ID")
    public ResponseEntity<Prompt> getPromptById(@PathVariable UUID id) {
        return ResponseEntity.ok(promptService.getPromptById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new prompt")
    public ResponseEntity<Prompt> createPrompt(@Valid @RequestBody PromptDto promptDto) {
        return new ResponseEntity<>(promptService.createPrompt(promptDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing prompt")
    public ResponseEntity<Prompt> updatePrompt(
            @PathVariable UUID id,
            @Valid @RequestBody PromptDto promptDto) throws JsonMappingException {
        return ResponseEntity.ok(promptService.updatePrompt(id, promptDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a prompt")
    public ResponseEntity<Void> deletePrompt(@PathVariable UUID id) {
        promptService.deletePrompt(id);
        return ResponseEntity.noContent().build();
    }
}
