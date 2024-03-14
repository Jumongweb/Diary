package data.repositories;

import data.models.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    List<Entry> findAll();
    Entry findById(int id);
    Long count();
    void delete(int id);
}
