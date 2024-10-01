package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{
    Resume[] storage = new Resume[10000];
    int size = 0;

    public void clear() {
        int i;
        for (i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }
    public void update(Resume r) {
        for (int i = 0; i < size; i++){
            if(storage[i].getUuid().equals(r.getUuid())) {
                return;
            }
        }
        System.out.println("ERROR");
    }

    public void save(Resume r) {
        if (size < storage.length) {
            storage[size++] = r;
        } else {
            System.out.println("Хранилище полно");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid != null && uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}


