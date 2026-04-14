package ca.bcit.comp2522.termproject.singletonfiles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EntityFactoryTest
{
    private static final String  VALID_SUSPECT_STRING             = "SUSPECT|Logico The Great|Pondering a puzzle|185|Blue|true";
    private static final String  EXPECTED_SUSPECT_NAME            = "Logico The Great";
    private static final boolean EXPECTED_SUSPECT_INNOCENT_STATUS = true;

    private static final String  VALID_WEAPON_STRING           = "WEAPON|Heavy Iron Candlestick|Heavy-weight|true";
    private static final String  EXPECTED_WEAPON_NAME          = "Heavy Iron Candlestick";
    private static final boolean EXPECTED_WEAPON_MURDER_STATUS = true;

    private static final String  VALID_LOCATION_STRING           = "LOCATION|The Abandoned Observatory|true|true";
    private static final String  EXPECTED_LOCATION_NAME          = "The Abandoned Observatory";
    private static final boolean EXPECTED_LOCATION_MURDER_STATUS = true;

    private static final String INVALID_EMPTY_STRING              = "";
    private static final String INVALID_UNKNOWN_TYPE_STRING       = "ALIEN|Bob|Mars";
    private static final String INVALID_INSUFFICIENT_PARTS_STRING = "SUSPECT|Logico The Great";

    @Test
    void testCreateEntityValidSuspect()
    {
        final Entity parsedEntity;
        final Suspect parsedSuspect;

        parsedEntity = EntityFactory.createEntity(VALID_SUSPECT_STRING);
        assertInstanceOf(Suspect.class,
                         parsedEntity);

        parsedSuspect = (Suspect) parsedEntity;
        assertEquals(EXPECTED_SUSPECT_NAME,
                     parsedSuspect.getName());
        assertEquals(EXPECTED_SUSPECT_INNOCENT_STATUS,
                     parsedSuspect.getInnocent());
    }

    @Test
    void testCreateEntityValidWeapon()
    {
        final Entity parsedEntity;
        final Weapon parsedWeapon;

        parsedEntity = EntityFactory.createEntity(VALID_WEAPON_STRING);
        assertInstanceOf(Weapon.class,
                         parsedEntity);

        parsedWeapon = (Weapon) parsedEntity;
        assertEquals(EXPECTED_WEAPON_NAME,
                     parsedWeapon.getName());
        assertEquals(EXPECTED_WEAPON_MURDER_STATUS,
                     parsedWeapon.getMurderWeapon());
    }

    @Test
    void testCreateEntityValidLocation()
    {
        final Entity parsedEntity;
        final Location parsedLocation;

        parsedEntity = EntityFactory.createEntity(VALID_LOCATION_STRING);
        assertInstanceOf(Location.class,
                         parsedEntity);

        parsedLocation = (Location) parsedEntity;
        assertEquals(EXPECTED_LOCATION_NAME,
                     parsedLocation.getName());
        assertEquals(EXPECTED_LOCATION_MURDER_STATUS,
                     parsedLocation.getMurderLocation());
    }

    @Test
    void testCreateEntityNullStringThrowsException()
    {
        final Executable entityCreationExecutable;

        entityCreationExecutable = () -> EntityFactory.createEntity(null);

        assertThrows(IllegalArgumentException.class,
                     entityCreationExecutable);
    }

    @Test
    void testCreateEntityEmptyStringThrowsException()
    {
        final Executable entityCreationExecutable;

        entityCreationExecutable = () -> EntityFactory.createEntity(INVALID_EMPTY_STRING);

        assertThrows(IllegalArgumentException.class,
                     entityCreationExecutable);
    }

    @Test
    void testCreateEntityUnknownTypeThrowsException()
    {
        final Executable entityCreationExecutable;

        entityCreationExecutable = () -> EntityFactory.createEntity(INVALID_UNKNOWN_TYPE_STRING);

        assertThrows(IllegalArgumentException.class,
                     entityCreationExecutable);
    }

    @Test
    void testCreateEntityInsufficientDataThrowsException()
    {
        final Executable entityCreationExecutable;

        entityCreationExecutable = () -> EntityFactory.createEntity(INVALID_INSUFFICIENT_PARTS_STRING);

        assertThrows(IllegalArgumentException.class,
                     entityCreationExecutable);
    }
}