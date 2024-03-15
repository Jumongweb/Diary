package data.repositories;

import data.models.Diary;
import exceptions.DiaryNotFoundException;
import exceptions.UsernameExistException;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImp implements DiaryRepository {

    public static int getNumberOfDiaries() {
        return numberOfDiaries;
    }

    private static int numberOfDiaries;
    List<Diary> diaries = new ArrayList<>();



    @Override
    public Diary save(Diary diary) {
        validate(diary);
        numberOfDiaries++;
        diaries.add(diary);
        return diary;
    }

    @Override
    public List<Diary> findSome(Diary... diary) {
        List<Diary> searchedDiary = new ArrayList<>();
        for (int i = 0; i < diary.length; i++){
            if (diaries.contains(diary[i])){
                searchedDiary.add(diary[i]);
            }
        }

        return searchedDiary;
    }

    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary findById(String username) {
        Diary foundDiary = null;
        for (Diary diary : diaries){
            if (diary.getUsername() == username){
                foundDiary = diary;
            }
        }
        if (foundDiary == null) throw new DiaryNotFoundException("Diary does not exit");
        return foundDiary;
    }

    @Override
    public Long count() {
        return (long) diaries.size();
    }

    @Override
    public void delete(String username) {
        Diary diary = findById(username);
        diaries.remove(diary);
    }

    @Override
    public void delete(Diary diary) {
        Diary diaryToBeDeleted = null;
        for (Diary searchDiary : diaries ){
            if (searchDiary.getUsername() == diary.getUsername()) {
                diaryToBeDeleted = searchDiary;
                diaries.remove(diaryToBeDeleted);
                break;
            }
        }
        if (diaryToBeDeleted == null) throw new DiaryNotFoundException("Diary does not exist");
    }


    public void validate(Diary diary){
        for (Diary existingDiary : diaries){
            if (existingDiary.getUsername() == diary.getUsername()){
                throw new UsernameExistException("Username already exist");
            }
        }
    }

}
