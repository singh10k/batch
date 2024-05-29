package com.Batch.in.exceptions;

public class FileWriteException extends Exception {
    public FileWriteException() {
        super("Failed to write to the file.");
    }

    public FileWriteException(String message) {
        super(message);
    }

    public FileWriteException(Throwable cause) {
        super(cause);
    }

    public FileWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
