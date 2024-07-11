import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    // Инициализация массива для хранения резюме
    Resume[] storage = new Resume[10000];
    // Переменная для отслеживания количества резюме в хранилище
    int size = 0;

    // Метод для очистки хранилища
    void clear() {
        // Заполняем весь массив null, очищая его
        Arrays.fill(storage, null);
        // Обнуляем размер хранилища
        size = 0;
    }

    // Метод для сохранения резюме
    void save(Resume r) {
        // Проверяем, есть ли еще место в хранилище
        if (size < storage.length) {
            // Если есть, сохраняем резюме и увеличиваем размер хранилища
            storage[size++] = r;
        } else {
            // Если нет, выводим сообщение об ошибке
            System.out.println("Хранилище полно");
        }
    }

    // Метод для получения резюме по uuid
    Resume get(String uuid) {
        // Проходим по всему хранилищу
        for (int i = 0; i < size; i++) {
            // Если находим нужное резюме, возвращаем его. Здесь происходит сравнение объекта по UUID
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        // Если резюме не найдено, возвращаем null
        return null;
    }

    // Метод для удаления резюме по uuid
    void delete(String uuid) {
        // Проходим по всему хранилищу
        for (int i = 0; i < size; i++) {
            // Если находим нужное резюме
            if (storage[i].uuid.equals(uuid)) {
                // Заменяем его последним резюме в хранилище
                storage[i] = storage[size - 1];
                // Удаляем последнее резюме
                storage[size - 1] = null;
                // Уменьшаем размер хранилища
                size--;
                // Прерываем цикл
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    // Метод для получения всех резюме
    Resume[] getAll() {
        // Возвращаем копию хранилища без null элементов
        return Arrays.copyOfRange(storage, 0, size);
    }

    // Метод для получения размера хранилища
    int size() {
        // Возвращаем текущий размер хранилища
        return size;
    }
}


