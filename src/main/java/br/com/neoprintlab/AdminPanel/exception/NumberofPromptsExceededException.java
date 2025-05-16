package br.com.neoprintlab.AdminPanel.exception;

public class NumberofPromptsExceededException extends RuntimeException {
    public NumberofPromptsExceededException(String message) {
        super(message);
    }
}
