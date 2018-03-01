package ru.mirea;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import java.util.ArrayList;

public class Dictionary {

    static ArrayList<Tag> listTags = new ArrayList<Tag>() {{
        add(new Tag("USD", "Dollar USA"));
        add(new Tag("RUB", "Ruble RUS"));
        add(new Tag("EUR", "Euro USA"));
        add(new Tag("EUROOOOO", "Euro США"));
        add(new Tag("LIB", "Dollar USA"));
        add(new Tag("TEM", "Ruble RUS"));
        add(new Tag("EUROPUS", "Euro USA"));
    }};

    // Метод поиска тегов начинаюшихся с определенных символов,
    // возвращающий список с такими тегами
    public static ArrayList<Tag> searchToListTags(String searchMnemo) {
        ArrayList<Tag> newList = new ArrayList<Tag>();
        for (Tag el : listTags) {
            if (el.getMnemo().startsWith(searchMnemo)) {
                newList.add(el);
            }
        }
        return newList;
    }

    // Метод вывода списка тегов
    public static String getTags(ArrayList<Tag> list) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (list.size() > 0) {
            return mapper.writeValueAsString(list);
        }
        else return "Список пуст!";
    }

    // Изменения тега по мнемонике,
    // возвращающий статус выполнения
    public static String setTag(String mnemo, String name) {
        for (Tag el : listTags) {
            if (el.getMnemo().equals(mnemo)) {
                el.setName(name);
                return "Тег успешно обновлен!";
            }
        }
        return "Тег не найден...";
    }

    // Метод удаления тега по мнемонике
    public static String deleteTag(String mnemo) {
        if (listTags.size() > 0) {
            for (Tag el : listTags) {
                if (el.getMnemo().equals(mnemo)) {
                    listTags.remove(el);
                    return "Тег успешно удален!";
                }
            }
            return "Тег не найден...";
        }
        else return "Список пустой...";
    }

}