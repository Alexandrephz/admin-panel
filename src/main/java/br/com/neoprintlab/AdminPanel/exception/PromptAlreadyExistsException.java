package br.com.neoprintlab.AdminPanel.exception;

public class PromptAlreadyExistsException extends RuntimeException {
    public PromptAlreadyExistsException(String message) {
        super(message);
    }
}
