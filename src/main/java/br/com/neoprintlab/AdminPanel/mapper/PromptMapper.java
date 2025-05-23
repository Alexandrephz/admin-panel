package br.com.neoprintlab.AdminPanel.mapper;

import br.com.neoprintlab.AdminPanel.dto.request.PromptDto;
import br.com.neoprintlab.AdminPanel.model.entity.Prompt;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromptMapper {
    Prompt toEntity(PromptDto dto);
}