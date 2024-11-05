### Задача 4: **Парольный менеджер**
- **Описание**: Напишите класс `PasswordManager`, который хранит и проверяет пароли.
- **Требования**:
    - Метод `addPassword(String username, String password)` для сохранения пароля для конкретного пользователя.
    - Метод `checkPassword(String username, String password)` возвращает `true`, если пароль совпадает, иначе `false`.
    - Пароли должны храниться в `Map<String, String>` (где ключ — имя пользователя).
