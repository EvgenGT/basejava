package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
        System.out.println("Хранилище очищено");
    }

    @Override
    public void update(Resume r) {
        int index = Arrays.binarySearch(storage, 0, size, r);

        if (index >= 0) {
            storage[index] = r;
            System.out.println("Resume updated: " + r.getUuid());
        } else {
            System.out.println("ERROR: Resume not found for UUID: " + r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        int index = Arrays.binarySearch(storage, 0, size, r);

        if (index >= 0) {
            System.out.println("ERROR: Resume already exists with UUID: " + r.getUuid());
            return;
        }

        int insertIndex = -index - 1;

        if (size >= storage.length) {
            System.out.println("ERROR: Storage is full, can't save the resume.");
            return;
        }
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = r;
        size++;
        System.out.println("Resume saved: " + r.getUuid());
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
