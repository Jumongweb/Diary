package services;

import dtos.requests.RegisterRequest;

public interface DiaryService {
    void register(RegisterRequest registerRequest);
    void login();

    long getNumberOfUsers();

}
