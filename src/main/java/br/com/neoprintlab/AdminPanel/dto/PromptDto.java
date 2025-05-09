package br.com.neoprintlab.AdminPanel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptDto {
    private String title;
    private String content;
    private String category;
    private String ai_service;
    private String is_active;
}
