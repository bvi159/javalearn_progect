package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import com.javarush.task.task32.task3209.listeners.UndoListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public View() {
        try {
            // Устанавливаем look and feel системы
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Логируем исключение, но не пробрасываем его дальше
            ExceptionHandler.log(e);
        }
    }

    public void setController(Controller controller) {

        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    /**
     * Обрабатывает действия от пунктов меню
     * @ param actionEvent событие действия
     *    HTML Editor (19)
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // 19.1. Получаем команду из события
        String command = actionEvent.getActionCommand();

        // 19.2. Обрабатываем команду "Новый"
        if (command.equals("Новый")) {
            controller.createNewDocument();
        }
        // 19.3. Обрабатываем команду "Открыть"
        else if (command.equals("Открыть")) {
            controller.openDocument();
        }
        // 19.4. Обрабатываем команду "Сохранить"
        else if (command.equals("Сохранить")) {
            controller.saveDocument();
        }
        // 19.5. Обрабатываем команду "Сохранить как..."
        else if (command.equals("Сохранить как...")) {
            controller.saveDocumentAs();
        }
        // 19.6. Обрабатываем команду "Выход"
        else if (command.equals("Выход")) {
            controller.exit();
        }
        // 19.7. Обрабатываем команду "О программе"
        else if (command.equals("О программе")) {
            showAbout();
        }

    }

    public void init() {
        // 4.3.1. Вызываем инициализацию графического интерфейса
        initGui();
        // 4.3.2. Добавляем слушателя событий окна
        addWindowListener(new FrameListener(this));
        // 4.3.3. Показываем окно
        setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // 9.1.2. Инициализируем меню в нужном порядке
        MenuHelper.initFileMenu(this, menuBar);        // Файл
        MenuHelper.initEditMenu(this, menuBar);        // Редактировать
        MenuHelper.initStyleMenu(this, menuBar);       // Стиль
        MenuHelper.initAlignMenu(this, menuBar);       // Выравнивание
        MenuHelper.initColorMenu(this, menuBar);       // Цвет
        MenuHelper.initFontMenu(this, menuBar);        // Шрифт
        MenuHelper.initHelpMenu(this, menuBar);        // Помощь

        // 9.1.3. Добавляем панель меню в верхнюю часть фрейма
        getContentPane().add(menuBar, BorderLayout.NORTH);

        /*
        // Создаем меню Файл
        JMenu fileMenu = new JMenu("Файл");

        // Создаем пункты меню
        JMenuItem newFile = new JMenuItem("Новый");
        JMenuItem openFile = new JMenuItem("Открыть");
        JMenuItem saveFile = new JMenuItem("Сохранить");
        JMenuItem saveAsFile = new JMenuItem("Сохранить как...");
        JMenuItem exitItem = new JMenuItem("Выход");

        // Добавляем пункты в меню Файл
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.addSeparator(); // Разделитель
        fileMenu.add(exitItem);

        // Создаем меню Редактировать
        JMenu editMenu = new JMenu("Редактировать");

        // Создаем пункты меню
        JMenuItem undoItem = new JMenuItem("Отменить");
        JMenuItem redoItem = new JMenuItem("Вернуть");
        JMenuItem cutItem = new JMenuItem("Вырезать");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenuItem pasteItem = new JMenuItem("Вставить");

        // Добавляем пункты в меню Редактировать
        editMenu.add(undoItem);
        editMenu.add(redoItem);
        editMenu.addSeparator();
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Создаем меню Стиль
        JMenu styleMenu = new JMenu("Стиль");

        // Создаем меню Выравнивание
        JMenu alignMenu = new JMenu("Выравнивание");
        JMenuItem leftAlign = new JMenuItem("По левому краю");
        JMenuItem centerAlign = new JMenuItem("По центру");
        JMenuItem rightAlign = new JMenuItem("По правому краю");

        alignMenu.add(leftAlign);
        alignMenu.add(centerAlign);
        alignMenu.add(rightAlign);

        // Добавляем подменю в меню Стиль
        styleMenu.add(alignMenu);

        // Создаем меню Цвет
        JMenu colorMenu = new JMenu("Цвет");
        JMenuItem textColor = new JMenuItem("Цвет текста");
        JMenuItem bgColor = new JMenuItem("Цвет фона");

        colorMenu.add(textColor);
        colorMenu.add(bgColor);

        // Добавляем подменю в меню Стиль
        styleMenu.add(colorMenu);

        // Создаем меню Шрифт
        JMenu fontMenu = new JMenu("Шрифт");
        JMenuItem plainFont = new JMenuItem("Обычный");
        JMenuItem boldFont = new JMenuItem("Жирный");
        JMenuItem italicFont = new JMenuItem("Курсив");

        fontMenu.add(plainFont);
        fontMenu.add(boldFont);
        fontMenu.add(italicFont);

        // Добавляем подменю в меню Стиль
        styleMenu.add(fontMenu);

        // Создаем меню Справка
        JMenu helpMenu = new JMenu("Справка");
        JMenuItem aboutItem = new JMenuItem("О программе");

        helpMenu.add(aboutItem);

        // Добавляем все меню в строку меню
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(styleMenu);
        menuBar.add(helpMenu);

        // Устанавливаем строку меню в окно
        setJMenuBar(menuBar);

         */
    }

    /**
     * Метод инициализации редактора
     */
    public void initEditor() {
        // 6.1. Устанавливаем значение "text/html" в качестве типа контента для htmlTextPane
        htmlTextPane.setContentType("text/html");
        // 6.2. Создаем новый локальный компонент JScrollPane на базе htmlTextPane
        JScrollPane htmlScrollPane = new JScrollPane(htmlTextPane);
        // 6.3. Добавляем вкладку в панель tabbedPane с именем "HTML" и компонентом JScrollPane
        tabbedPane.addTab("HTML", htmlScrollPane);

        // 6.4. Создаем новый локальный компонент JScrollPane на базе plainTextPane
        JScrollPane plainScrollPane = new JScrollPane(plainTextPane);
        // 6.5. Добавляем еще одну вкладку в tabbedPane с именем "Текст" и компонентом JScrollPane
        tabbedPane.addTab("Текст", plainScrollPane);

        // 6.6. Устанавливаем предпочтительный размер панели tabbedPane
        // Размер 500x400 пикселей
        tabbedPane.setPreferredSize(new Dimension(300, 300));

        // 6.7. Создаем объект класса TabbedPaneChangeListener
        // и устанавливаем его в качестве слушателя изменений в tabbedPane
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        // 6.8. Добавляем по центру панели контента текущего фрейма нашу панель с вкладками
        // Получаем панель контента и добавляем tabbedPane в центр с помощью BorderLayout.CENTER
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    // 4.2. Объявляем метод initGui()
    /**
     * Метод инициализации графического интерфейса
     */
    public void initGui() {
        // Инициализируем меню
        initMenuBar();
        // Инициализируем редактор
        initEditor();
        /*
         * Метод pack() - автоматически устанавливает размер окна
         * таким образом, чтобы все компоненты помещались в нем
         * с учетом их предпочтительных размеров.
         * Это удобно, так как не нужно задавать фиксированные размеры.
         */
        pack();
    }

    /**
     * Вызывается при смене выбранной вкладки
     * HTML Editor (18)
     */
    public void selectedTabChanged() {
         //18.1. Проверяем, какая вкладка сейчас выбрана
        int selectedIndex = tabbedPane.getSelectedIndex();

        if (selectedIndex == 0) {
            // 18.2. Если выбрана HTML вкладка (индекс 0)
            // Получаем текст из plainTextPane и устанавливаем его в контроллер
            String text = plainTextPane.getText();
            controller.setPlainText(text);
        } else if (selectedIndex == 1) {
            // 18.3. Если выбрана вкладка с текстом (индекс 1)
            // Получаем текст у контроллера и устанавливаем его в plainTextPane
            String text = controller.getPlainText();
            plainTextPane.setText(text);
        }

        // 18.4. Сбрасываем правки
        resetUndo();
    }

//    // 10.3.1. Метод-заглушка для проверки возможности отмены
//    public boolean canUndo() {
//        return false;
//    }
//
//    // 10.3.3. Метод-заглушка для проверки возможности возврата
//    public boolean canRedo() {
//        return false;
//    }


    // 11.1. Поле UndoManager
    private UndoManager undoManager = new UndoManager();

    // 11.4. Поле UndoListener
    private UndoListener undoListener = new UndoListener(undoManager);

    // ... существующий код класса View ...

    // 11.5.1. Метод отмены последнего действия
    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            // Дщгируем исключение
            ExceptionHandler.log(e);
        }
    }

    // 11.5.2. Метод возврата ранее отменённого действия
    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            // Дщгируем исключение
            ExceptionHandler.log(e);
        }
    }

    // 11.5.3. Реализация методов проверки возможности отмены/возврата
//    @Override
    public boolean canUndo() {
        return undoManager.canUndo();
    }

//    @Override
    public boolean canRedo() {
        return undoManager.canRedo();
    }

    // 11.5.4. Геттер для undoListener
    public UndoListener getUndoListener() {
        return undoListener;
    }

    // 11.5.5. Метод сброса всех правок
    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    /**
     * Проверяет, выбрана ли вкладка с HTML редактором
     * @return true если выбрана вкладка с индексом 0 (HTML), иначе false
     * HTML Editor (13)
     */
    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    /**
     * Выбирает HTML вкладку и сбрасывает все правки
     */
    public void selectHtmlTab() {
        // 14.1.1. Выбираем html вкладку (индекс 0)
        tabbedPane.setSelectedIndex(0);

        // 14.1.2. Сбрасываем все правки с помощью метода reset()
        resetUndo();
    }

    /**
     * Обновляет документ в панели редактирования htmlTextPane
     */
    public void update() {
        // Получаем документ у контроллера
        Document document = controller.getDocument();

        // Устанавливаем полученный документ в htmlTextPane
        htmlTextPane.setDocument(document);
    }

    /**
     * Показывает диалоговое окно с информацией о программе
     */
    public void showAbout() {
        // Создаем текст для диалогового окна
        String aboutText = "HTML Редактор\n" +
                "Версия 1.0\n" +
                "Разработчик: JavaRush\n" +
                "Программа для редактирования HTML кода и текста";

        // Показываем диалоговое окно с информацией
        JOptionPane.showMessageDialog(this,
                aboutText,
                "О программе",
                JOptionPane.INFORMATION_MESSAGE);
    }


    // ... остальной код класса View ...

}