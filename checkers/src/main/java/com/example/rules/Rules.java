package com.example.rules;
import com.example.model.*;

public interface Rules {
    MoveResult applyMove(Board board, int x, int y, Stone color);
}
