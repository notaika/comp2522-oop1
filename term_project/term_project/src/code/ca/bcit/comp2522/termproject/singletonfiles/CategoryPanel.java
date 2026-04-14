package ca.bcit.comp2522.termproject.singletonfiles;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;

/**
 * Concrete panel for displaying lists of game entities (Suspects, Weapons, Locations).
 * Utilizes bounded generics and extends AbstractGamePanel.
 * Polymorphically calls getDetails() on each Entity to display crucial game clues.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.2
 */
public final class CategoryPanel<T extends Entity> extends AbstractGamePanel
{
    private static final double ICON_SIZE_PIXELS = 28.0;
    private static final int REGION_SIZE = 3;
    private static final int SPACING_TEXT_CONTAINER_PIXELS = 2;

    /**
     * Constructs the generic CategoryPanel.
     *
     * @param titleText the panel title
     * @param entities the list of entities to display
     * @param iconPaths the array of image paths for the icons
     */
    public CategoryPanel(final String titleText,
                         final List<T> entities,
                         final String[] iconPaths)
    {
        super(titleText);

        for (int i = 0; i < REGION_SIZE; i++)
        {
            final HBox row;
            final Image iconImage;
            final ImageView icon;
            final VBox textContainer;
            final Label nameLabel;
            final Label detailsLabel;

            row = new HBox();
            iconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconPaths[i])));
            icon = new ImageView(iconImage);

            // Create a VBox specifically to stack the Name and Details vertically
            textContainer = new VBox(SPACING_TEXT_CONTAINER_PIXELS);

            nameLabel = new Label(entities.get(i).getName());
            detailsLabel = new Label("> " + entities.get(i).getDetails());

            // Assign distinct CSS classes so we can make the details smaller
            nameLabel.getStyleClass().add("entity-name");
            detailsLabel.getStyleClass().add("entity-details");

            // Allow the details to wrap, and FORCE it to display its full height without "..."
            detailsLabel.setWrapText(true);
            detailsLabel.setMinHeight(Label.USE_PREF_SIZE);

            row.getStyleClass().add("entity-row");

            icon.setFitWidth(ICON_SIZE_PIXELS);
            icon.setFitHeight(ICON_SIZE_PIXELS);

            // Add the labels to the VBox, and tell the VBox to grow horizontally as much as possible
            textContainer.getChildren().addAll(nameLabel, detailsLabel);
            HBox.setHgrow(textContainer, Priority.ALWAYS);

            row.getChildren().addAll(icon, textContainer);

            this.getChildren().add(row);
        }
    }
}