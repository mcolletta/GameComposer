package de.mirkosertic.gamecomposer.contentarea;

import de.mirkosertic.gamecomposer.Controller;
import de.mirkosertic.gamecomposer.FlushResourceCacheEvent;
import de.mirkosertic.gamecomposer.ObjectSelectedEvent;
import de.mirkosertic.gamecomposer.ShutdownEvent;
import de.mirkosertic.gameengine.event.PropertyChanged;
import javafx.scene.control.Tab;
import javafx.scene.input.KeyEvent;

public interface ContentController<T> extends Controller {

    T getEditingObject();

    void processKeyPressedEvent(KeyEvent aKeyEvent);

    void processKeyReleasedEvent(KeyEvent aKeyEvent);

    void addedAsTab();

    void removed();

    void onObjectSelected(ObjectSelectedEvent aEvent);

    void onShutdown(ShutdownEvent aEvent);

    void onObjectUpdated(Tab aTab, PropertyChanged aEvent);

    void onFlushResourceCache(FlushResourceCacheEvent aEvent);
}