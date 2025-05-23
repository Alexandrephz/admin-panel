package br.com.neoprintlab.AdminPanel.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptDto {
    private String name;
    private String content;
    private String category;
}


