## **Задача 13: Парсер CSV файлов**
- **Описание**: Напишите класс `CSVParser` с методом `parse(String filePath)`, который считывает CSV-файл и возвращает список `Map<String, String>`, представляющий каждую строку.
- **Требования**:
    - Используйте заголовок файла CSV как ключи для значений в каждой строке.
    - Поддержите обработку запятых внутри кавычек.