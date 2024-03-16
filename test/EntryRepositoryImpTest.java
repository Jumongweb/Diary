import data.models.Entry;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImp;
import data.repositories.EntryRepository;
import data.repositories.EntryRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImpTest {
    private EntryRepository repository;

    @BeforeEach
    public void setUp(){
        repository = new EntryRepositoryImp();
    }
    @Test
    public void testThatUserRepositoryCanSaveEntry(){
        assertEquals(0L, repository.count());
        Entry entry = new Entry("title", "body", "author");
        repository.save(entry);
        assertEquals(1L, repository.count());
    }
}
