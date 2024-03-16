package data.repositories;

import data.models.Entry;

import java.util.List;

public class EntryRepositoryImp implements EntryRepository{
    private EntryRepository repository = new EntryRepositoryImp();
    @Override
    public Entry save(Entry entry) {
        repository.save(entry);
        return entry;
    }

    @Override
    public List<Entry> findAll() {
        return null;
    }

    @Override
    public Entry findById(int id) {
        return null;
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public void delete(int id) {

    }
}
