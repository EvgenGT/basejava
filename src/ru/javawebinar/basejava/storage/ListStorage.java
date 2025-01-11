package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public abstract class ListStorage extends AbstractStorage {

    public static boolean update(ArrayList<String> resumes, String resumeToCheck) {
        return resumes.contains(resumeToCheck);
    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }
}
