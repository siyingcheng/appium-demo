package com.simon.core.mobile;

public enum Alert {
    ACCEPT("accept"),
    DISMISS("dismiss"),
    GET_BUTTONS("getButtons");
    private final String action;

    Alert(String action) {
        this.action = action;
    }

    public String action() {
        return this.action;
    }
}
