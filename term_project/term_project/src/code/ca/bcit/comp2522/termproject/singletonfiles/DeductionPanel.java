package ca.bcit.comp2522.termproject.singletonfiles;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Encapsulates the Deduction Box.
 * Implements GridObserver and extends AbstractGamePanel.
 *
 * @author Aika Manalo - Set 2C
 * @version 2.0
 */
public final class DeductionPanel
        extends AbstractGamePanel
        implements GridObserver
{
    private final Label whoValueLabel;
    private final Label whatValueLabel;
    private final Label whenValueLabel;

    /**
     * Constructs the DeductionPanel.
     *
     * @param accuseAction the runnable action to execute when the Accuse button is clicked
     */
    public DeductionPanel(final Runnable accuseAction)
    {
        super("DEDUCTIONS");

        final VBox whoBox;
        final VBox whatBox;
        final VBox whenBox;
        final Label whoTitle;
        final Label whatTitle;
        final Label whenTitle;
        final HBox accuseContainer;
        final Button accuseButton;

        whoBox          = new VBox();
        whatBox         = new VBox();
        whenBox         = new VBox();
        whoTitle        = new Label("WHO");
        whatTitle       = new Label("WHAT");
        whenTitle       = new Label("WHEN");
        accuseContainer = new HBox();
        accuseButton    = new Button("ACCUSE!");

        this.whoValueLabel  = new Label(" ");
        this.whatValueLabel = new Label(" ");
        this.whenValueLabel = new Label(" ");

        whoTitle.getStyleClass()
                .add("deduction-title");
        whatTitle.getStyleClass()
                 .add("deduction-title");
        whenTitle.getStyleClass()
                 .add("deduction-title");

        whoBox.getStyleClass()
              .add("aligned-box");
        whatBox.getStyleClass()
               .add("aligned-box");
        whenBox.getStyleClass()
               .add("aligned-box");

        whoBox.getChildren()
              .addAll(whoValueLabel,
                      whoTitle);
        whatBox.getChildren()
               .addAll(whatValueLabel,
                       whatTitle);
        whenBox.getChildren()
               .addAll(whenValueLabel,
                       whenTitle);

        accuseButton.getStyleClass()
                    .addAll("button",
                            "accuse-button");
        accuseButton.setOnAction(event -> accuseAction.run());

        accuseContainer.setAlignment(Pos.CENTER);
        accuseContainer.getChildren()
                       .add(accuseButton);

        VBox.setVgrow(whoBox,
                      Priority.ALWAYS);
        VBox.setVgrow(whatBox,
                      Priority.ALWAYS);
        VBox.setVgrow(whenBox,
                      Priority.ALWAYS);

        this.getChildren()
            .addAll(whoBox,
                    whatBox,
                    whenBox,
                    accuseContainer);
    }

    /**
     * Automatically updates the labels when the grid confirms new deductions.
     *
     * @param who the deduced suspect
     * @param what the deduced weapon
     * @param when the deduced location
     */
    @Override
    public void onDeductionUpdated(final String who,
                                   final String what,
                                   final String when)
    {
        this.whoValueLabel.setText(who);
        this.whatValueLabel.setText(what);
        this.whenValueLabel.setText(when);
    }

    /**
     * Gets the deduced suspect's name.
     *
     * @return the deduced who as a String
     */
    public String getDeducedWho()
    {
        return whoValueLabel.getText();
    }

    /**
     * Gets the deduced weapon's name.
     *
     * @return the deduced what as a String
     */
    public String getDeducedWhat()
    {
        return whatValueLabel.getText();
    }

    /**
     * Gets the deduced location's name.
     *
     * @return the deduced when as a String
     */
    public String getDeducedWhen()
    {
        return whenValueLabel.getText();
    }
}