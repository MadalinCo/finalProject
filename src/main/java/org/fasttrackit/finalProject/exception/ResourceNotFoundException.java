package org.fasttrackit.finalProject.exception;

import lombok.Getter;

public class ResourceNotFoundException extends RuntimeException{
    @Getter
    private final long entityId;

    public ResourceNotFoundException(String message, long entityId) {
        super(message);
        this.entityId = entityId;
    }
}
