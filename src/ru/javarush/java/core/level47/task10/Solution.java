package ru.javarush.java.core.level47.task10;

/*
Управление Списком Праздничных Дат в Календаре 🎉
Представьте, что вы создаете приложение-календарь, и вам необходимо хранить список праздничных или выходных дней в формате XML.

Создайте класс Calendar с полем List<LocalDate> holidays, которое будет содержать все эти особые даты.

Ваша задача — разработать адаптер, который сможет корректно сериализовать каждую отдельную дату в этом списке в универсальный формат "dd.MM.yyyy".

Чтобы XML-представление списка holidays было чистым и структурированным, используйте аннотации @XmlElementWrapper для создания общего контейнера для списка дат и @XmlElement для каждого отдельного элемента даты.

Примените ваш адаптер к элементам списка с помощью @XmlJavaTypeAdapter.

После этого выполните сериализацию объекта Calendar в XML. В результате ваш XML-документ должен содержать красиво оформленный список дат, где каждая дата будет записана в требуемом формате, облегчая дальнейшую обработку и чтение.

Требования:
•	Необходимо создать класс с именем Calendar, в котором будет поле holidays типа List<LocalDate>.
•	Поле holidays должно быть аннотировано @XmlElementWrapper для создания контейнера в XML и @XmlElement для каждого элемента списка.
•	Необходимо создать пользовательский адаптер (XmlAdapter), который будет сериализовать и десериализовать объекты LocalDate в строковый формат "dd.MM.yyyy" и обратно.
•	Для элементов списка holidays требуется использовать аннотацию @XmlJavaTypeAdapter с указанием созданного адаптера.
•	В результате сериализации объект Calendar должен преобразовываться в XML, где список holidays представлен контейнером, а каждая дата — элементом с форматом "dd.MM.yyyy".
•	Для сериализации и аннотирования необходимо использовать стандартные классы и аннотации JAXB: @XmlRootElement, @XmlElementWrapper, @XmlElement, @XmlJavaTypeAdapter.
•	XML-документ после сериализации должен содержать структурированный список дат, соответствующий требованиям задачи.

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Заполняем календарь несколькими праздничными датами
        Calendar calendar = new Calendar();
        calendar.addHoliday(LocalDate.of(2025, 1, 1));   // 01.01.2025
        calendar.addHoliday(LocalDate.of(2025, 5, 9));   // 09.05.2025
        calendar.addHoliday(LocalDate.of(2025, 12, 31)); // 31.12.2025

        // Готовим JAXB к сериализации класса Calendar


        // Включаем форматированный вывод для читаемости


        // Сериализация в стандартный вывод (консоль)
        // В XML будет контейнер <holidays> и элементы <date> с датами в формате dd.MM.yyyy

    }
}

 */

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Заполняем календарь несколькими праздничными датами
        Calendar calendar = new Calendar();
        calendar.addHoliday(LocalDate.of(2025, 1, 1));   // 01.01.2025
        calendar.addHoliday(LocalDate.of(2025, 5, 9));   // 09.05.2025
        calendar.addHoliday(LocalDate.of(2025, 12, 31)); // 31.12.2025

        // Готовим JAXB к сериализации класса Calendar
        JAXBContext context = JAXBContext.newInstance(Calendar.class);
        Marshaller marshaller = context.createMarshaller();

        // Включаем форматированный вывод для читаемости
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Сериализация в стандартный вывод (консоль)
        // В XML будет контейнер <holidays> и элементы <date> с датами в формате dd.MM.yyyy
        marshaller.marshal(calendar, System.out);

    }
}

/*
package ru.javarush.java.core.level47.task10;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Заполняем календарь несколькими праздничными датами
        Calendar calendar = new Calendar();
        calendar.addHoliday(LocalDate.of(2025, 1, 1));   // 01.01.2025
        calendar.addHoliday(LocalDate.of(2025, 5, 9));   // 09.05.2025
        calendar.addHoliday(LocalDate.of(2025, 12, 31)); // 31.12.2025

        // Готовим JAXB к сериализации класса Calendar
        JAXBContext context = JAXBContext.newInstance(Calendar.class);
        Marshaller marshaller = context.createMarshaller();

        // Включаем форматированный вывод для читаемости
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Сериализация в стандартный вывод (консоль)
        // В XML будет контейнер <holidays> и элементы <date> с датами в формате dd.MM.yyyy
        marshaller.marshal(calendar, System.out);
    }
}


 */