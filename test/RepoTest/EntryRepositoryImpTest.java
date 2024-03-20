package RepoTest;

import data.models.Entry;
import data.repositories.EntryRepository;
import data.repositories.EntryRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImpTest {
    private static EntryRepository repository;
    @BeforeEach
    public void setUp(){
        repository = new EntryRepositoryImp();
    }

    @Test
    public void testThatIhaveRepositoryThatCanStoreDiariesAndItIsEmptyByDefault(){
        assertEquals(0l, repository.count());
    }

    @Test
    public void testThatRepositoryCanSaveEntry(){
        assertEquals(0L, repository.count());
        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setBody("Body of diary");
        repository.save(entry);
        assertEquals(1L, repository.count());
    }

    @Test
    public void testSaveThreeEntry_repositoryCountIs3(){
        assertEquals(0l, repository.count());
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        Entry entry3 = new Entry();
        entry1.setTitle("title");
        entry1.setBody("Body of diary");
        entry2.setTitle("title");
        entry2.setBody("Body of diary");
        entry3.setTitle("title");
        entry3.setBody("Body of diary");
        repository.save(entry1);
        repository.save(entry2);
        repository.save(entry3);
        assertEquals(3l, repository.count());
    }

    @Test
    public void testThatRepositoryCanFindEntryById(){
        Entry entry1 = new Entry();
        repository.save(entry1);
        Entry foundEntry = repository.findById(1);
        assertEquals(1, foundEntry.getId());
    }

    @Test
    public void testThatRepositoryCanDeleteEntryById(){
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        entry1.setTitle("title");
        entry1.setBody("Body of diary");
        entry2.setTitle("title");
        entry2.setBody("Body of diary");
        repository.save(entry1);
        repository.save(entry2);
        assertEquals(2l, repository.count());
        repository.delete(1);
        assertEquals(1l, repository.count());
    }

    @Test
    public void testThatRepositoryCanDeleteEntryByEntryName(){
        Entry entry1 = new Entry();
        entry1.setTitle("title");
        entry1.setBody("Body of diary");

        Entry entry2 = new Entry();
        entry2.setTitle("title");
        entry2.setBody("Body of diary");
        repository.save(entry1);
        repository.save(entry2);
        assertEquals(2l, repository.count());
        repository.delete(entry1);
        assertEquals(1l, repository.count());
    }

    @Test
    public void testThatRepositoryCanFindAllEntries(){
        Entry entry1 = new Entry();
        entry1.setTitle("title");
        entry1.setBody("Body of diary");
        Entry firstEntry = repository.save(entry1);

        Entry entry2 = new Entry();
        entry2.setTitle("title");
        entry2.setBody("Body of diary");
        Entry secondEntry = repository.save(entry2);

        List<Entry> expected = new ArrayList<>();
        expected.add(firstEntry);
        expected.add(secondEntry);
        assertEquals(expected, repository.findAll());
    }

    @Test
    public void testCreateTwoEntriesDeleteOne_CreateOneMore_TheIdIs3(){
        Entry entry1 = new Entry();
        entry1.setTitle("title");
        entry1.setBody("body of entry");
        repository.save(entry1);

        Entry entry2 = new Entry();
        entry2.setTitle("title");
        entry2.setBody("body of entry");
        repository.save(entry2);

        repository.delete(entry2);

        Entry entry3 = new Entry();
        entry3.setTitle("title");
        entry3.setBody("body of entry");
        repository.save(entry3);

        assertEquals(3, entry3.getId());
    }

    @Test
    public void testThatRepositoryCanUpdateEntry(){
        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setBody("Body of diary");
        repository.save(entry);

        Entry entryToBeUpdated = repository.findById(1);
        entryToBeUpdated.setTitle("new title");
        entryToBeUpdated.setBody("new body");
        repository.save(entryToBeUpdated);

        assertEquals(1, entryToBeUpdated.getId());
        assertEquals("new title", entryToBeUpdated.getTitle());
        assertEquals("new body", entryToBeUpdated.getBody());
    }


}
