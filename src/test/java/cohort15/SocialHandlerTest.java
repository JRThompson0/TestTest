package cohort15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SocialHandlerTest
{
    SocialHandler socialHandler = new SocialHandler();
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
    @Test
    void handleChangeTest()
    {
        String handle1 = socialHandler.addGuy("bougat");
        User daGuy = socialHandler.getGuy(handle1);
        String handle2 = socialHandler.changeHandle("douglass",daGuy);
        String handleGrab = daGuy.getLowerCaseHandle();
        assertEquals(handle2,handleGrab);
        //System.out.println(daGuy);
        //System.out.println(socialHandler.getGuy("@douglass"));
        //System.out.println(socialHandler.daMap.toString());
        assertEquals("@bougat",socialHandler.addGuy("bougat"));
    }
    @Test
    void handleChangeFails()
    //all of the exceptions from adding a person apply to
    // changing a name, which gives a guideline for testing.
    {
        String name1 = "123456789";
        String name2 = "toshi";
        socialHandler.addGuy(name1);
        socialHandler.addGuy(name2);
        User daGuy = socialHandler.getGuy("@"+name1);
        User daOtherguy = socialHandler.getGuy("@"+name2);

        Assertions.assertThrows(InputMismatchException.class,
                ()->socialHandler.changeHandle("123456789",daGuy),
                "Should throw exepction when username remains the same.");

        Assertions.assertThrows(InputMismatchException.class,
        ()-> socialHandler.changeHandle("123456789",daOtherguy),
        "Should throw exepction when username already in system entered.");

        Assertions.assertThrows(InputMismatchException.class,
                ()->socialHandler.addGuy("12345678912312"),
                "Should throw exception when username is too long.");
        Assertions.assertThrows(InputMismatchException.class,
                ()->socialHandler.changeHandle("",daGuy),
                "Should throw exepction when blank or null entered");
        Assertions.assertThrows(NullPointerException.class,
                ()->socialHandler.changeHandle(null,daOtherguy),
                "Should throw exepction when blank or null entered");
    }
    @Test
    void writeFileTest()
    {
        socialHandler.addGuy("Michael");
        socialHandler.addGuy("Tychael");
        socialHandler.addGuy("BooGIE");
        socialHandler.addGuy("GOOOOOOPR");
        socialHandler.fileWrite("logFile.txt");
        SocialHandler.readFile("logFile.txt");
    }
}