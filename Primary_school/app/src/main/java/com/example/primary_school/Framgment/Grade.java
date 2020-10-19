package com.example.primary_school.Framgment;

import java.io.Serializable;

public class Grade implements Serializable {
    private String tograde;

    public Grade(String tograde) {
        this.tograde = tograde;
    }

    public String getTograde() {
        return tograde;
    }
}
