package ca.bcit.comp2522.termproject.singletonfiles;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;

/**
 * Abstract base class for all UI panels in the game.
 * Enforces the common "bordered-panel" styling and header layout.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public abstract class AbstractGamePanel
        extends VBox
{
    protected final HBox titleBar;

    /**
     * Constructs and initializes the base panel with a stylized title.
     *
     * @param titleText the string to display as the panel's heading
     */
    protected AbstractGamePanel(final String titleText)
    {
        super();
        final Label titleLabel;

        this.titleBar = new HBox();
        titleLabel    = new Label(titleText);

        this.getStyleClass()
            .add("bordered-panel");
        titleLabel.getStyleClass()
                  .add("panel-heading");
        titleLabel.setMaxWidth(Double.MAX_VALUE);

        this.titleBar.getChildren()
                     .add(titleLabel);
        this.getChildren()
            .add(this.titleBar);
    }
}