package com.xzit.model;

import lombok.Data;

@Data
public class DriverQuery extends DriverInfo{
    private Person person;

    @Override
    public String toString() {
        return "DriverQuery{" +
                "person=" + person +
                '}';
    }
}
