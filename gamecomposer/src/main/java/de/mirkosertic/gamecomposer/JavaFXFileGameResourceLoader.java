package de.mirkosertic.gamecomposer;

import de.mirkosertic.gameengine.javafx.JavaFXAbstractGameResourceLoader;
import de.mirkosertic.gameengine.type.ResourceName;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JavaFXFileGameResourceLoader extends JavaFXAbstractGameResourceLoader {

    private final File baseDirectory;

    public JavaFXFileGameResourceLoader(File aBaseDirectory) {
        baseDirectory = aBaseDirectory;
    }

    @Override
    protected InputStream getInputStreamFor(ResourceName aResourceName) throws IOException {
        return new FileInputStream(new File(baseDirectory, aResourceName.name));
    }
}