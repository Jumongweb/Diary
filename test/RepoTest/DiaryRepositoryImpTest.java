package RepoTest;

import data.models.Diary;
import exceptions.DiaryNotFoundException;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImp;
import exceptions.UsernameExistException;
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
        Diary diary1 = new Diary();
        diary1.setUsername("username");
        diary1.setPassword("password");
        repository.save(diary1);
        assertEquals(1, repository.count());
    }

    @Test
    public void testThatRepositoryThrowExceptionIfDiaryWithTheSameUsernameIsSaved(){
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        diary1.setUsername("username");
        diary1.setPassword("password");
        diary2.setUsername("username");
        diary2.setPassword("password");
        repository.save(diary1);
        assertThrows(UsernameExistException.class, ()->repository.save(diary2));
    }

    @Test
    public void testThatRepositoryCanFindDiary(){
        Diary diary1 = new Diary();
        diary1.setUsername("username");
        diary1.setPassword("password");
        repository.save(diary1);
        assertEquals(diary1, repository.findById("username"));
    }

    /* @Test
    public void testSearchForDiaryNotInRepository_RepositoryThrowException(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        diary1.setUsername("username1");
        diary1.setPassword("password");
        diary2.setUsername("username2");
        diary2.setPassword("password");
        repository.save(diary1);
        assertThrows(DiaryNotFoundException.class, ()->repository.findById("username2"));
    } */

    @Test
    public void testThatRepositoryCanSaveThreeOrAboveDiary(){
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        Diary diary3 = new Diary();
        diary1.setUsername("username1");
        diary1.setPassword("password");
        diary2.setUsername("username2");
        diary2.setPassword("password");
        diary3.setUsername("username3");
        diary3.setPassword("password");

        repository.save(diary1);
        repository.save(diary2);
        repository.save(diary3);
        assertEquals(3l, repository.count());
    }

    @Test
    public void testThatRepositorycanDeleteDiaryByUsername(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        diary1.setUsername("username1");
        diary1.setPassword("password");
        diary2.setUsername("username2");
        diary2.setPassword("password");
        repository.save(diary1);
        repository.save(diary2);
        assertEquals(2l, repository.count());
        repository.delete("username1");
        assertEquals(1l, repository.count());
    }

    /* @Test
    public void testDeleteDiaryByUsernameThatDoesNotExistDiaryThrowException(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        diary1.setUsername("username1");
        diary1.setPassword("password");
        diary2.setUsername("username2");
        diary2.setPassword("password");
        repository.save(diary1);
        repository.save(diary2);
        assertEquals(2l, repository.count());
        assertThrows(DiaryNotFoundException.class, ()->repository.delete("username3"));
        assertEquals(2l, repository.count());
    } */



    @Test
    public void testThatRepositorycanDeleteDiaryByDiary(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        diary1.setUsername("username1");
        diary1.setPassword("password");
        diary2.setUsername("username2");
        diary2.setPassword("password");
        repository.save(diary1);
        repository.save(diary2);
        assertEquals(2l, repository.count());
        repository.delete(diary2);
        assertEquals(1l, repository.count());
    }

    @Test
    public void testDeleteDiaryThatDoesNotExistInTheRepository_RepositoryThrowsException(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        Diary diary3 = new Diary();
        diary1.setUsername("username1");
        diary1.setPassword("password");
        diary2.setUsername("username2");
        diary2.setPassword("password");
        diary3.setUsername("username3");
        diary3.setPassword("password");
        repository.save(diary1);
        repository.save(diary2);
        assertEquals(2l, repository.count());
        assertThrows(DiaryNotFoundException.class, ()->repository.delete(diary3));
    }

    @Test
    public void testThatRepositoryCanSomeListOfDiary(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        Diary diary3 = new Diary();
        Diary diary4 = new Diary();
        Diary diary5 = new Diary();
        diary1.setUsername("username1");
        diary1.setPassword("password");
        diary2.setUsername("username2");
        diary2.setPassword("password");
        diary3.setUsername("username3");
        diary3.setPassword("password");
        diary4.setUsername("username4");
        diary4.setPassword("password");
        diary5.setUsername("username5");
        diary5.setPassword("password");
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
        assertEquals(expectedDiaries, repository.findSome(diary1, diary3, diary5));

    }

    @Test
    public void testThatRepositoryCanFindAllDiaries(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        Diary diary3 = new Diary();
        Diary diary4 = new Diary();
        Diary diary5 = new Diary();
        diary1.setUsername("username1");
        diary1.setPassword("password");
        diary2.setUsername("username2");
        diary2.setPassword("password");
        diary3.setUsername("username3");
        diary3.setPassword("password");
        diary4.setUsername("username4");
        diary4.setPassword("password");
        diary5.setUsername("username5");
        diary5.setPassword("password");
        repository.save(diary1);
        repository.save(diary2);
        repository.save(diary3);
        repository.save(diary4);
        repository.save(diary5);
        assertEquals(5l, repository.count());
        List<Diary> expectedDiaries = new ArrayList<>();
        expectedDiaries.add(diary1);
        expectedDiaries.add(diary2);
        expectedDiaries.add(diary3);
        expectedDiaries.add(diary4);
        expectedDiaries.add(diary5);
        assertEquals(expectedDiaries, repository.findAll());
    }


}
