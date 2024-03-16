import dtos.requests.RegisterRequest;
import exceptions.UsernameExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryService;
import services.DiaryServiceImp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiaryServiceImpTest {

    private DiaryService diaryService;

    @BeforeEach
    public void initializer(){
        diaryService = new DiaryServiceImp();
    }

    @Test
    public void testThatUserServiceHasZeroNumberOfUserByDefault(){
        assertEquals(0, diaryService.getNumberOfUsers());
    }
    @Test
    public void testThatUserCanBeAddedThroughRequestService(){
        RegisterRequest registerRequest = new RegisterRequest("username", "password");
        diaryService.register(registerRequest);
        assertEquals(1, diaryService.getNumberOfUsers());
    }

    @Test
    public void testThatUserWithTheSameUsernameCannotBeAddedThroughRequestService(){
        RegisterRequest registerRequest = new RegisterRequest("username", "password");
        RegisterRequest registerRequest2 = new RegisterRequest("username", "password");
        diaryService.register(registerRequest);
        assertThrows(UsernameExistException.class, ()->diaryService.register(registerRequest2));
        assertEquals(1, diaryService.getNumberOfUsers());
    }

    @Test
    public void testAddThreeUser_NumberOfUserIsThree(){
        assertEquals(0, diaryService.getNumberOfUsers());
        RegisterRequest registerRequest1 = new RegisterRequest("username1", "password");
        RegisterRequest registerRequest2 = new RegisterRequest("username2", "password");
        RegisterRequest registerRequest3 = new RegisterRequest("username3", "password");
        diaryService.register(registerRequest1);
        diaryService.register(registerRequest2);
        diaryService.register(registerRequest3);
        assertEquals(3, diaryService.getNumberOfUsers());
    }
}
