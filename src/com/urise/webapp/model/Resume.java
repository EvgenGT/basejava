package com.urise.webapp.model;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    public String uuid;

    @Override
    public String toString() {
        return getUuid();
    }

    public String getUuid() {
        return null;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
