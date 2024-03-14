import data.models.Diary;
import data.repositories.DiaryNotFoundException;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImp;
import data.repositories.UsernameExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImpTest {
    private static DiaryRepository repository;
    @BeforeEach
    public void setUp(){
        repository = new DiaryRepositoryImp();
    }

    @Test
    public void testThatIhaveRepositoryThatCanStoreDiariesAndItIsEmptyByDefault(){
        assertEquals(0l, repository.count());
    }
    @Test
    public void testThatRepositoryCanSaveDiary(){
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary1 = new Diary("username", "password");
        repository.save(diary1);
        assertEquals(1l, repository.count());
    }

    @Test
    public void testThatRepositoryThrowExceptionIfDiaryWithTheSameUsernameIsSaved(){
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary1 = new Diary("username", "password");
        Diary diary2 = new Diary("username", "password");
        repository.save(diary1);
        assertThrows(UsernameExistException.class, ()->repository.save(diary2));
    }

    @Test
    public void testThatRepositoryCanFindDiary(){
        Diary diary1 = new Diary("username", "password");
        repository.save(diary1);
        assertEquals(diary1, repository.findById("username"));
    }

    @Test
    public void testSearchForDiaryNotInRepository_RepositoryThrowException(){
        Diary diary1 = new Diary("username1", "password");
        Diary diary2 = new Diary("username2", "password");
        repository.save(diary1);
        assertThrows(DiaryNotFoundException.class, ()->repository.findById("username2"));
    }

    @Test
    public void testThatRepositoryCanSaveThreeOrAboveDiary(){
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary1 = new Diary("username1", "password");
        Diary diary2 = new Diary("username2", "password");
        Diary diary3 = new Diary("username3", "password");

        repository.save(diary1);
        repository.save(diary2);
        repository.save(diary3);
        assertEquals(3l, repository.count());
    }

    @Test
    public void testThatRepositorycanDeleteDiaryByUsername(){
        Diary diary1 = new Diary("username1", "password");
        Diary diary2 = new Diary("username2", "password");
        repository.save(diary1);
        repository.save(diary2);
        assertEquals(2l, repository.count());
        repository.delete("username1");
        assertEquals(1l, repository.count());
    }

    @Test
    public void testDeleteDiaryByUsernameThatDoesNotExistDiaryThrowException(){
        Diary diary1 = new Diary("username1", "password");
        Diary diary2 = new Diary("username2", "password");
        repository.save(diary1);
        repository.save(diary2);
        assertEquals(2l, repository.count());
        assertThrows(DiaryNotFoundException.class, ()->repository.delete("username3"));
        assertEquals(2l, repository.count());
    }



    @Test
    public void testThatRepositorycanDeleteDiaryByDiary(){
        Diary diary1 = new Diary("username1", "password");
        Diary diary2 = new Diary("username2", "password");
        repository.save(diary1);
        repository.save(diary2);
        assertEquals(2l, repository.count());
        repository.delete(diary2);
        assertEquals(1l, repository.count());
    }

    @Test
    public void testDeleteDiaryThatDoesNotExistInTheRepository_RepositoryThrowsException(){
        Diary diary1 = new Diary("username1", "password");
        Diary diary2 = new Diary("username2", "password");
        Diary diary3 = new Diary("username3", "password");
        repository.save(diary1);
        repository.save(diary2);
        assertEquals(2l, repository.count());
        assertThrows(DiaryNotFoundException.class, ()->repository.delete(diary3));
    }

    @Test
    public void testThatRepositoryCanFindListOfDiary(){
        Diary diary1 = new Diary("username1", "password");
        Diary diary2 = new Diary("username2", "password");
        Diary diary3 = new Diary("username3", "password");
        Diary diary4 = new Diary("username4", "password");
        Diary diary5 = new Diary("username5", "password");
        repository.save(diary1);
        repository.save(diary2);
        repository.save(diary3);
        repository.save(diary4);
        repository.save(diary5);
        assertEquals(5l, repository.count());
        List<Diary> expectedDiaries = new ArrayList<>();
        expectedDiaries.add(diary1);
        expectedDiaries.add(diary3);
        expectedDiaries.add(diary5);
        assertEquals(expectedDiaries, repository.findAll(diary1, diary3, diary5));

    }
}
