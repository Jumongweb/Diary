package services;

import data.models.Diary;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImp;
import dtos.requests.RegisterRequest;
import exceptions.UsernameExistException;

public class DiaryServiceImp implements DiaryService{
    private DiaryRepository repository = new DiaryRepositoryImp();
    @Override
    public void register(RegisterRequest registerRequest) {
        validate(registerRequest);
        Diary diary = new Diary();
        diary.setUsername(registerRequest.getUsername());
        diary.setPassword(registerRequest.getPassword());
        repository.save(diary);
    }

    public void validate(RegisterRequest registerRequest){
        if (repository.findById(registerRequest.getUsername()) != null) {
            throw new UsernameExistException("Username already exist");
        }
    }

    @Override
    public void login() {

    }

    @Override
    public long getNumberOfUsers() {
        return repository.count();
    }


}
