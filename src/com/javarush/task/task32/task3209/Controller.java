package com.javarush.task.task32.task3209;
/*
Сегодня мы напишем HTML редактор с графическим интерфейсом.
В качестве библиотеки для создания графического интерфейса воспользуемся Swing.
А в качестве архитектурного каркаса нашего приложения будем использовать MVC модель.
1.1. Объяви класс Controller и класс View.
Класс View должен быть унаследован от JFrame и реализовывать интерфейс ActionListener.
1.2. Добавь в класс Controller поля, отвечающие за представление View view и модель HTMLDocument document. Здесь и далее, классы, которые мы не объявляли, но используем в коде скорее всего все находятся в библиотеке swing.
Например, класс HTMLDocument реализован в пакете javax.swing.text.html.
1.3. Добавь в класс Controller поле, которое будет отвечать за файл, который сейчас открыт в нашем редакторе (текущий файл) File currentFile.
1.4. Добавь конструктор класса Controller. Он должен принимать в качестве параметра представление и инициализировать соответствующее поле класса.
1.5. Добавь в Controller пустой метод main.
1.6. Добавь в класс View поле Controller controller.
1.7. Добавь в класс View сеттер и геттер для поля controller.
1.8. Добавь пустую реализацию метода, который объявлен в интерфейсе ActionListener.

Требования:
•	Класс Controller должен быть создан в отдельном файле.
•	Класс View должен быть создан в отдельном файле.
•	Класс View должен быть унаследован от JFrame и реализовывать интерфейс ActionListener.
•	В классе Controller должны быть приватные поля: View view, HTMLDocument document, File currentFile.
•	В классе Controller должен быть создан метод public static void main (String[] args).
•	Класс Controller должен содержать конструктор с одним параметром, инициализирующий поле view.
•	В классе View должно быть приватное поле Controller controller, а также сеттер и геттер к нему.
•	В классе View должен быть метод public void actionPerformed(ActionEvent e)

 */


import javax.swing.*;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
//import javax.swing.undo.UndoableEditListener;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    // 2.1. Метод init() для инициализации контроллера
    public void init() {
        // Реализация будет добавлена позже
        // 20.2. Вызываем метод создания нового документа
        createNewDocument();
    }
//    /**
//     * Заглушка для создания нового документа
//     * HTML Editor (19)
//     */
//    public void createNewDocument() {
//        // Реализация будет добавлена позже
//    }

    /**
     * Создает новый документ
     */
    public void createNewDocument() {
        // 20.1.1. Выбираем html вкладку у представления
        view.selectHtmlTab();

        // 20.1.2. Сбрасываем текущий документ
        resetDocument();

        // 20.1.3. Устанавливаем новый заголовок окна
        view.setTitle("HTML редактор");

        // 20.1.4. Обнуляем переменную currentFile
        currentFile = null;
    }

    /**
     * Геттер для документа
     * @return текущий документ
     * HTML Editor (14)
     */
    public HTMLDocument getDocument() {
        return document;
    }

    /**
     * Сбрасывает текущий документ
     * HTML Editor (15)
     */
    public void resetDocument() {
        // 15.1. Удаляем у текущего документа слушателя правок
        if (document != null) {
            // Получаем слушателя правок у представления и удаляем его из документа
            UndoableEditListener undoListener = view.getUndoListener();
            document.removeUndoableEditListener(undoListener);
        }

        // 15.2. Создаем новый документ по умолчанию
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlEditorKit.createDefaultDocument();

        // 15.3. Добавляем новому документу слушателя правок
        UndoableEditListener undoListener = view.getUndoListener();
        document.addUndoableEditListener(undoListener);

        // 15.4. Вызываем у представления метод update()
        view.update();
    }


    /**
     * Записывает переданный текст с HTML тегами в документ
     * @param text текст с HTML тегами для записи в документ
     */
    public void setPlainText(String text) {
        // 16.1. Сбрасываем документ
        resetDocument();

        // 16.2. Создаем новый ридер на базе переданного текста
        StringReader reader = new StringReader(text);

        try {
            // 16.3. Вызываем метод read() из HTMLEditorKit для чтения данных в документ
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.read(reader, document, 0);
        } catch (Exception e) {
            // 16.4. Логируем исключение, если оно возникло
            ExceptionHandler.log(e);
        }
    }

    /**
     * Получает текст из документа со всеми HTML тегами
     * @return текст документа с HTML тегами
     * HTML Editor (17)
     */
    public String getPlainText() {
        // 17.1. Создаем объект StringWriter
        StringWriter writer = new StringWriter();

        try {
            // 17.2. Переписываем содержимое из документа в созданный объект
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.write(writer, document, 0, document.getLength());
        } catch (Exception e) {
            // 17.3. Логируем исключение, если оно возникло
            ExceptionHandler.log(e);
        }

        // Возвращаем текст из StringWriter
        return writer.toString();
    }

    public static void main(String[] args) {
        // 2.2.1. Создаем объект представления
        View view = new View();

        // 2.2.2. Создаем контроллер, используя представление
        Controller controller = new Controller(view);

        // 2.2.3. Устанавливаем у представления контроллер
        view.setController(controller);

        // 2.2.4. Инициализируем представление
        view.init();

        // 2.2.5. Инициализируем контроллер
        controller.init();
    }


//    /**
//     * Заглушка для открытия документа
//     */
//    public void openDocument() {
//        // Реализация будет добавлена позже
//    }

    /**
     * Открывает документ из файла
     */
    public void openDocument() {
        // Переключаем представление на html вкладку
        view.selectHtmlTab();

        // Создаем новый объект для выбора файла
        JFileChooser fileChooser = new JFileChooser();

        // Устанавливаем фильтр HTMLFileFilter
        fileChooser.setFileFilter(new HTMLFileFilter());

        // Показываем диалоговое окно для открытия файла
        int result = fileChooser.showOpenDialog(view);

        // Если пользователь подтвердил выбор файла
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                // Устанавливаем новое значение currentFile
                currentFile = fileChooser.getSelectedFile();

                // Сбрасываем документ
                resetDocument();

                // Устанавливаем имя файла в заголовок окна
                view.setTitle(currentFile.getName());

                // Создаем FileReader на базе currentFile
                FileReader fileReader = new FileReader(currentFile);

                // Вычитываем данные из FileReader-а в документ document
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.read(fileReader, document, 0);

                // Закрываем FileReader
                fileReader.close();

                // Сбрасываем правки
                view.resetUndo();

            } catch (Exception e) {
                // Логируем исключение
                ExceptionHandler.log(e);
            }
        }
    }

//    /**
//     * Заглушка для сохранения документа
//     */
//    public void saveDocument() {
//        // Реализация будет добавлена позже
//    }
    /**
     * Сохраняет текущий документ в файл
     */
    public void saveDocument() {
        // Переключаем представление на html вкладку
        view.selectHtmlTab();

        // Если currentFile равен null, вызываем saveDocumentAs()
        if (currentFile == null) {
            saveDocumentAs();
        } else {
            try {
                // Создаем FileWriter на базе currentFile
                FileWriter fileWriter = new FileWriter(currentFile);

                // Переписываем данные из документа в FileWriter
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.write(fileWriter, document, 0, document.getLength());

                // Закрываем FileWriter
                fileWriter.close();
            } catch (Exception e) {
                // Логируем исключение
                ExceptionHandler.log(e);
            }
        }
    }

//    /**
//     * Заглушка для сохранения документа как...
//     */
//    public void saveDocumentAs() {
//        // Реализация будет добавлена позже
//    }
    /**
     * Сохраняет документ как новый файл
     */
    public void saveDocumentAs() {
        // 22.1. Переключаем представление на html вкладку
        view.selectHtmlTab();

        // 22.2. Создаем новый объект для выбора файла
        JFileChooser fileChooser = new JFileChooser();

        // 22.3. Устанавливаем фильтр HTMLFileFilter
        fileChooser.setFileFilter(new HTMLFileFilter());

        // 22.4. Показываем диалоговое окно для сохранения файла
        int result = fileChooser.showSaveDialog(view);

        // 22.5. Если пользователь подтвердил выбор файла
        if (result == JFileChooser.APPROVE_OPTION) {
            // 22.5.1. Сохраняем выбранный файл в поле currentFile
            currentFile = fileChooser.getSelectedFile();

            // 22.5.2. Устанавливаем имя файла как заголовок окна
            view.setTitle(currentFile.getName());

            try {
                // 22.5.3. Создаем FileWriter на базе currentFile
                FileWriter fileWriter = new FileWriter(currentFile);

                // 22.5.4. Переписываем данные из документа в FileWriter
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.write(fileWriter, document, 0, document.getLength());

                // Закрываем FileWriter
                fileWriter.close();
            } catch (Exception e) {
                // 22.6. Логируем исключение
                ExceptionHandler.log(e);
            }
        }
    }

    // 2.3. Метод exit() для завершения программы
    public void exit() {
        // 2.3.1. Метод не статический
        System.exit(0);
    }
}

