package br.com.neoprintlab.AdminPanel.exception;

public class NumberOfPromptsExceededException extends RuntimeException {
    public NumberOfPromptsExceededException(String message) {
        super(message);
    }
}
