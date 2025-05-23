package br.com.neoprintlab.AdminPanel.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String errorCode;
    private String message;
    private long timestamp;

}
