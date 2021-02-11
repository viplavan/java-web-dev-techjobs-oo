package org.launchcode.techjobs_oo;

import java.util.Objects;

public class PositionType extends JobField{
    private int id;
    private static int nextId = 1;
    private String value;

    public PositionType() {
        super();
    }

    public PositionType(String value) {
        super(value);
    }
}
