package de.mirkosertic.gameengine.physics;

import de.mirkosertic.gameengine.types.Position;

public interface PhysicsDebugCanvas {

    void drawLine(Position p1, Position p2, boolean aAwake);

    void drawPosition(Position p);
}