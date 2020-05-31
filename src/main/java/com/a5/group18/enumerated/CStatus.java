package com.a5.group18.enumerated;

/**
 * @author Tim Shi
 * @version 1.0
 */
public enum CStatus {
    AVAILABLE("AVAILABLE"), SUSPEND("SUSPEND"), NOT_AVAILABLE("NOT_AVAILABLE");

    private String description;

    CStatus(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
