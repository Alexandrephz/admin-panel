package br.com.neoprintlab.AdminPanel.model.entity;

import br.com.neoprintlab.AdminPanel.dto.PromptDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "prompts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prompt {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 4000)
    private String content;

    @Column(nullable = false)
    private String category;

    @ElementCollection
    @CollectionTable(name = "prompt_tags", joinColumns = @JoinColumn(name = "prompt_id"))
    @Column(name = "tag")
    private Set<String> tags = new HashSet<>();

    @Column(name = "ai_service", nullable = false)
    private String aiService = "DALLE";

    @Column(name = "parameters", columnDefinition = "jsonb")
    private String parameters = "{}";

    @Column(name = "is_active")
    private boolean active = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Prompt(PromptDto promptDto) {
        promptDto.getCategory() = category;
        promptDto.getContent() = content;
        promptDto.getTitle() = getTitle();
        promptDto.getAi_service() = aiService;
        promptDto.getIs_active() = isActive();
    }
}