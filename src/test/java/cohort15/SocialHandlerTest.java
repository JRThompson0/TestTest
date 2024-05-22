package cohort15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SocialHandlerTest
{
    static SocialHandler socialHandler = new SocialHandler();
    @Test
    void addGuyTests()
    {
        String name1 = "JohnnyB";
        String name2 = "Dougat";
        String concatName1 = socialHandler.addGuy(name1);
        String concatName2 = socialHandler.addGuy(name2);
        assert(socialHandler.getGuy("@johnnyb") != null);
        assertNotEquals(socialHandler.getGuy(concatName1), socialHandler.getGuy(concatName2));
        assertEquals(socialHandler.getGuy(concatName1).getHandle(), name1);
    }
    @Test
    void emptyTest()
    {
        Assertions.assertThrows(InputMismatchException.class,
                ()->socialHandler.addGuy(""),
                "Should throw exepction when blank or null entered");
        Assertions.assertThrows(NullPointerException.class,
                ()->socialHandler.addGuy(null),
                "Should throw exepction when blank or null entered");
    }
    @Test
    void addTooLong()
    {
        Assertions.assertThrows(InputMismatchException.class,
                ()->socialHandler.addGuy("12345678912312"),
                "Should throw exception when username is too long.");
    }
    @Test
    void addRepeatGuyTests()
    {
        socialHandler.addGuy("123456789");
        Assertions.assertThrows(InputMismatchException.class,
                ()->socialHandler.addGuy("123456789"),
                "Should throw exepction when username already in system entered.");
    }
}