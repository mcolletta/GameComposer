package de.mirkosertic.gamecomposer.objectinspector.utils;

import de.mirkosertic.gamecomposer.objectinspector.PropertyEditorItem;
import de.mirkosertic.gameengine.type.Color;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;

import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.PropertyEditor;

public class ColorPropertyEditor implements PropertyEditor<Color> {

    private final ColorPicker colorPicker;
    private final PropertyEditorItem<Color> item;

    public ColorPropertyEditor(PropertySheet.Item aItem) {
        item = (PropertyEditorItem<Color>) aItem;
        colorPicker = new ColorPicker();
        colorPicker.setOnAction(event -> item.setValue(getValue()));
    }

    @Override
    public Node getEditor() {
        return colorPicker;
    }

    @Override
    public Color getValue() {
        javafx.scene.paint.Color theColor = colorPicker.getValue();
        return new Color((int)(255 * theColor.getRed()), (int)(255 * theColor.getGreen()), (int)(255 * theColor.getBlue()));
    }

    @Override
    public void setValue(Color aColor) {
        colorPicker.setValue(new javafx.scene.paint.Color(1d / 255 * aColor.r, 1d / 255 * aColor.g, 1d / 255 *  aColor.b, 1));
    }
}
