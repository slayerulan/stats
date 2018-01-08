package com.savik.parser.coeffs.x1stavka.hockey;


import java.util.HashMap;
import java.util.Map;

public class Book1xbetConstants {
    public static final String URL = "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&tf=3000000&afterDays=0&tz=0&sport=2&country=1&champ=";
    public static final String EVENT_URL = "https://1xecu.xyz/LineFeed/GetGameZip?lng=ru&cfview=0&isSubGames=true&GroupEvents=true&countevents=1000&grMode=2&id=";
    public static final String NHL = URL + "30619";
    public static final String KHL = URL + "3355";
    public static final String EXTRA = URL + "104959";
    public static final String DEL = URL + "104035";
    public static final String SHL = URL + "1388257";

    public static Map<String, String> khlMapping = new HashMap<String, String>(){
        {
            put("Куньлунь РС", "Красная Звезда Куньлунь");
            put("Спартак Москва", "Спартак");
            put("Витязь Подольск", "Витязь");
        }
    };

    public static Map<String, String> extraMapping = new HashMap<String, String>(){
        {
            put("Тршинец", "Оцеларжи");
            put("Хомутов", "Пираты");
            put("Либерец", "Били Тигржи");
            put("Плзень", "Шкода Пльзень");
            put("Млада Болеслав", "Млада");
            put("Хомутов", "Пираты");
            put("ХК Маунтфилд", "Градец Кралове");
        }
    };

    public static Map<String, String> delMapping = new HashMap<String, String>(){
        {
            put("Адлер Мангейм", "Маннгейм");
            put("Бремерхавен", "Фиштаун Пингвинс");
            put("Стробинг Тайгерз", "Штраубинг Тайгерс");
            put("Айсбарен Берлин", "Айсберен");
            put("Аугсбюргер", "Аугсбургер Пантер");
            put("Нюрнберг Айс Тайгерс", "Томас Сабо Айс Тайгерс");
            put("Исерлон", "Изерлон Рустерс");
        }
    };

    public static Map<String, String> shlMapping = new HashMap<String, String>(){
        {
            put("Лулео", "Лулеo"); // разные o
            put("Эребру", "Оребро");
            put("Векшё", "Ваксё Лейкерс");
            put("Векшё", "Ваксё Лейкерс");
            put("Линчеппинг", "Линчопинг");
            put("Карлскрона", "Карлскруна");
            put("Мальмо", "Мальме Ред Хоукс");
        }
    };

}
