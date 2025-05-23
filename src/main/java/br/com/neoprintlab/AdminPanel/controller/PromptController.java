package br.com.neoprintlab.AdminPanel.controller;

import br.com.neoprintlab.AdminPanel.dto.response.ErrorResponseDto;
import br.com.neoprintlab.AdminPanel.exception.NumberOfPromptsExceededException;
import br.com.neoprintlab.AdminPanel.exception.PromptServiceLogicException;
import br.com.neoprintlab.AdminPanel.model.entity.Prompt;
import br.com.neoprintlab.AdminPanel.service.PromptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.neoprintlab.AdminPanel.dto.request.PromptDto;

import java.util.List;

@RestController
@RequestMapping("/prompts")
@Tag(name = "Prompts", description = "APIs for managing AI generation prompts")
public class PromptController {

    @Autowired
    private PromptService promptService;

    @GetMapping
    @Operation(summary = "Get all prompts")
    public ResponseEntity<List<Prompt>> getAllPrompts() {
        List<Prompt> prompts = promptService.getAllPrompts();
        return new ResponseEntity<>(prompts, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> newPrompt(@RequestBody PromptDto promptDto){
        Prompt createdPrompt = promptService.createPrompt(promptDto);
        return new ResponseEntity<>(createdPrompt, HttpStatus.CREATED);
    }
}
