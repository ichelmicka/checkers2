package com.example.model;
import java.util.HashSet;
import java.util.Set;

public class Group {
    public final Stone color;
    public final Set<Position> stones = new HashSet<>();
    public final Set<Position> liberties = new HashSet<>();

    public Group(Stone color) {
        this.color = color;
    }
}
