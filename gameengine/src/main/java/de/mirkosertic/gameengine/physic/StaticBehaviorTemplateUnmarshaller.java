package de.mirkosertic.gameengine.physic;

import de.mirkosertic.gameengine.core.BehaviorTemplateUnmarshaller;
import de.mirkosertic.gameengine.core.GameObject;
import de.mirkosertic.gameengine.event.GameEventManager;

import java.util.Map;

public class StaticBehaviorTemplateUnmarshaller implements BehaviorTemplateUnmarshaller<StaticBehaviorTemplate> {

    @Override
    public String getTypeKey() {
        return StaticBehavior.TYPE;
    }

    @Override
    public StaticBehaviorTemplate deserialize(GameEventManager aEventmanager, GameObject aOwner, Map<String, Object> aSerializedData) {
        return StaticBehaviorTemplate.deserialize(aEventmanager, aOwner);
    }
}
