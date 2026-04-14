package ca.bcit.comp2522.termproject.singletonfiles;

/**
 * Represents a single cell in the logic grid pairing two entities.
 * Each cell can be in one of three states: Empty, Impossible (X), or Confirmed (O).
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public final class LogicCell<T extends Entity, U extends Entity>
{
    public static final char STATE_EMPTY = ' ';
    public static final char STATE_IMPOSSIBLE = 'X';
    public static final char STATE_CONFIRMED = 'O';

    private final T rowEntity;
    private final U columnEntity;
    private char state;

    /**
     * Constructs and initializes a LogicCell with its associated entities.
     * State is initialized to EMPTY using an instance initializer or default.
     *
     * @param rowEntity    the entity assigned to the row
     * @param columnEntity the entity assigned to the column
     * @throws IllegalArgumentException if either entity is null
     */
    public LogicCell(final T rowEntity,
                     final U columnEntity)
    {
        validateEntity(rowEntity, "Row Entity");
        validateEntity(columnEntity, "Column Entity");

        this.rowEntity = rowEntity;
        this.columnEntity = columnEntity;
        this.state = STATE_EMPTY;
    }

    /*
     * Validates that the provided entity is not null.
     *
     * @param entityToCheck the entity to check
     * @param entityType the type of game entity to validate
     * @throws IllegalArgumentException if the value is invalid
     */
    private static void validateEntity(final Entity entityToCheck,
                                       final String entityType)
    {
        if (entityToCheck == null)
        {
            throw new IllegalArgumentException("ERROR: " + entityType + " is invalid.");
        }
    }

    /**
     * Toggles the state of the cell in the sequence: Empty -> Impossible -> Confirmed -> Empty.
     */
    public void toggle()
    {
        switch (state)
        {
            case STATE_EMPTY ->
            {
                state = STATE_IMPOSSIBLE;
            }
            case STATE_IMPOSSIBLE ->
            {
                state = STATE_CONFIRMED;
            }
            default ->
            {
                state = STATE_EMPTY;
            }
        }
    }

    /**
     * Sets the state of the cell explicitly.
     *
     * @param newState the new state character (must be one of the symbolic constants)
     * @throws IllegalArgumentException if the state is not a valid constant
     */
    public void setState(final char newState)
    {
        validateState(newState);
        this.state = newState;
    }

    /*
     * Validates that the character matches a valid cell state.
     *
     * @param stateToValidate the state to check
     * @throws IllegalArgumentException if the value is invalid
     */
    private static void validateState(final char stateToValidate)
    {
        if (stateToValidate != STATE_EMPTY &&
            stateToValidate != STATE_IMPOSSIBLE &&
            stateToValidate != STATE_CONFIRMED)
        {
            throw new IllegalArgumentException("ERROR: Invalid cell state provided.");
        }
    }

    /**
     * Returns the current state of the cell.
     *
     * @return the state character
     */
    public char getState()
    {
        return state;
    }

    /**
     * Returns the entity associated with the row.
     *
     * @return the row entity
     */
    public T getRowEntity()
    {
        return rowEntity;
    }

    /**
     * Returns the entity associated with the column.
     *
     * @return the column entity
     */
    public U getColumnEntity()
    {
        return columnEntity;
    }

    /**
     * Returns a string representation of the cell's logic state.
     *
     * @return the state wrapped in brackets, e.g., "[X]"
     */
    @Override
    public String toString()
    {
        return "[" + state + "]";
    }
}
