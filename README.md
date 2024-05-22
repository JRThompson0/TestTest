SocialHandler - Limits social media handle to 9 characters or less

Can be used to create a social media handle with a maximum of 10 characters.
Method should be able to accept as many characters as possible as input.
All  social media handle characters must end up being lowercase.
Always attach an @ symbol at the front of their handle to make a total of 10 characters.
Social media Handle cannot be blank or null
Keep a list of every unique social media handle ever created successfully
Account for exceptions


Part 1: checkHandle sample method’s input and output as examples:
Example method input :  Attempt to create a handle with 12345678910
Example method output :  Result of creating handle is : @123456789

@Test
@DisplayName("To check if a social media handle was created successfully")
void createHandleTest() { to do }


@Test
@DisplayName("To check if handle was created with 9 characters or less")
void checkHandleLessThan9CharactersTest() { to do }


@Test // This is an example of how to test an exemption
@DisplayName("To check if social media handle input is null")
void checkIfNullTest() {
SocialHandle socialHandle = new SocialHandle();
assertThrows(NullPointerException.class, ()-> socialHandle.checkHandle(null));
}


@Test
@DisplayName("To check if social media handle is empty or blank")
void checkEmptyOrBlankCharactersTest(){ to do }



Part 2 : addHandle sample method’s input and output as examples:
Example method input :  Add 3 handles - Mike jones, Mike Jones and mike Jones
Example method output :  Number of handles created should only be 1
@Test
@DisplayName("To check if handle was added despite multiple attempts")
void addHandleTest(){ to do }


