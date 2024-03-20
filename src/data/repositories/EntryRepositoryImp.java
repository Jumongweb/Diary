package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImp implements EntryRepository{
    private int generateId;
    List<Entry> entries = new ArrayList<>();
    @Override
    public Entry save(Entry entry) {
        if (isNew(entry)){
            addIdTo(entry);
            entries.add(entry);
        }
        else {
            update(entry);
            return entry;
        }
        return entry;
    }

    private boolean isNew(Entry entry) {
//        for (Entry existingEntry : entries){
//            if (existingEntry.getId() == entry.getId()){
//                return false;
        return entry.getId() == 0;

//        return true;
 }

    private int generateId(){
        return ++generateId;
    }
    private void addIdTo(Entry entry){
        entry.setId(generateId());
    }

    @Override
    public List<Entry> findAll() {
        return entries;
    }

    @Override
    public Entry findById(int id) {
        for (Entry entry : entries){
            if (entry.getId() == id){
                return entry;
            }
        }
        return null;
    }

    @Override
    public Long count() {
        return (long) entries.size();
    }

    @Override
    public void delete(int id) {
        Entry entryToRemove = findById(id);
        if (entryToRemove != null){
            entries.remove(entryToRemove);
        }
    }

    @Override
    public void delete(Entry entry) {
        for (Entry entryToRemove : entries){
            if (entryToRemove.getId() == entry.getId()){
                entries.remove(entryToRemove);
                break;
            }
        }
    }

    @Override
    public void update(Entry entry) {
        for (Entry entryToUpdate : entries){
            if (entryToUpdate.getId() == entry.getId()){
                entryToUpdate.setTitle(entry.getTitle());
                entryToUpdate.setBody(entry.getBody());
            }
        }

    }


}
