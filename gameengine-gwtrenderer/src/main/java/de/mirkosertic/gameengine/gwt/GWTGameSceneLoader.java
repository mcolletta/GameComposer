package de.mirkosertic.gameengine.gwt;

import de.mirkosertic.gameengine.AbstractGameRuntimeFactory;
import de.mirkosertic.gameengine.core.Game;
import de.mirkosertic.gameengine.core.GameScene;

import java.util.Map;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

class GWTGameSceneLoader {

    public static interface GameSceneLoadedListener {
        void onGameSceneLoaded(GameScene aScene);
        void onGameSceneLoadedError(Throwable aThrowable);
    }

    private final GameSceneLoadedListener listener;
    private final AbstractGameRuntimeFactory runtimeFactory;

    public GWTGameSceneLoader(GameSceneLoadedListener aListener, AbstractGameRuntimeFactory aRuntimeFactory) {
        listener = aListener;
        runtimeFactory = aRuntimeFactory;
    }

    public void loadFromServer(final Game aGame, String aSceneName, final GWTGameResourceLoader aResourceLoader) {
        RequestBuilder theBuilder = new RequestBuilder(RequestBuilder.GET, aSceneName+"/scene.json");
        try {
            theBuilder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request aRequest, Response aResponse) {
                    listener.onGameSceneLoaded(parse(aGame, aResponse, aResourceLoader));
                }

                @Override
                public void onError(Request aRequest, Throwable aThrowable) {
                    listener.onGameSceneLoadedError(aThrowable);
                }
            });
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private GameScene parse(Game aGame, Response aResponse, GWTGameResourceLoader aResourceLoader) {
        JSONValue theJSONParsed = JSONParser.parseStrict(aResponse.getText());
        Map<String, Object> theResult = JSONUtils.toMap(theJSONParsed);
        return GameScene.deserialize(aGame, runtimeFactory.create(aResourceLoader, new GWTGameSoundSystemFactory()), theResult);
    }
}
