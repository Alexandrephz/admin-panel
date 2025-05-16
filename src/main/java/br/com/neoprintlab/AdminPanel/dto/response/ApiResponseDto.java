package br.com.neoprintlab.AdminPanel.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponseDto<T> {
    private String status;
    private T response;

}
