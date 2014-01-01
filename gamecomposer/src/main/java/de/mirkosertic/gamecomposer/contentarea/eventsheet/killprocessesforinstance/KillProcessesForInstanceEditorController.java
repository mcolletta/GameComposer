package de.mirkosertic.gamecomposer.contentarea.eventsheet.killprocessesforinstance;

import de.mirkosertic.gamecomposer.Controller;
import de.mirkosertic.gameengine.core.GameScene;
import de.mirkosertic.gameengine.processes.KillProcessesForInstanceAction;
import javafx.scene.Node;

public class KillProcessesForInstanceEditorController implements Controller {

    private Node view;
    private KillProcessesForInstanceAction action;
    private GameScene gameScene;

    KillProcessesForInstanceEditorController initialize(Node aView, GameScene aGameScene, KillProcessesForInstanceAction aAction) {
        view = aView;
        action = aAction;
        gameScene = aGameScene;

        return this;
    }

    public Node getView() {
        return view;
    }
}