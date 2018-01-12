package com.savik.parser.coeffs.x1stavka;


import java.util.HashMap;
import java.util.Map;

public class Book1xbetConstants {
    public static final String URL = "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&tf=3000000&afterDays=0&tz=0&sport=2&country=1&champ=";
    public static final String EVENT_URL = "https://1xecu.xyz/LineFeed/GetGameZip?lng=ru&cfview=0&isSubGames=true&GroupEvents=true&countevents=1500&grMode=2&id=";
    public static final String NHL = URL + "30619";
    public static final String KHL = URL + "3355";
    public static final String EXTRA = URL + "104959";
    public static final String DEL = URL + "104035";
    public static final String SHL = URL + "1388257";
    public static final String LA = URL + "127733";
    public static final String AUSTRALIA_A = URL + "104509";
    public static final String PORTUGAL_PREMIER = URL + "118663";
    public static final String INDIA_SUPERLIGA = URL + "1122087";
    public static final String BUNDESLIGA = URL + "96463";
    public static final String FRANCE_1 = URL + "12821";
    public static final String HOLLAND_1 = URL + "35677";
    public static final String HOLLAND_EREDIVISIE = URL + "119575";
    public static final String ENGLAND_PREMIER = URL + "88637";

    // hockey

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

    // football

    public static Map<String, String> indiaSuperligaMapping = new HashMap<String, String>(){
        {
            put("Дели Динамос", "Дели Дайнамос");
            put("Jamshedpur", "Джамшедпур");
            put("Норт-Ист Юнайтед", "Нортист Юнайтед");
            put("ATK", "Атлетико де Калькутта");
        }
    };

    public static Map<String, String> holland1Mapping = new HashMap<String, String>(){
        {
            put("Валвейк", "Ваалвейк");
            put("Йонг АЗ Алкмар", "АЗ II");
            put("Ден Босх", "Ден Бош");
            put("Алмере", "Алмере Сити");
            put("Йонг ПСВ", "ПСВ II");
            put("Хельмонд", "Хелмонд Спорт");
            put("Йонг Утрехт", "Утрехт II");
            put("Камбур", "Камбуур");
            put("Графсхап", "Де Графсхап");
            put("Маастрихт", "МВВ");
            put("Неймеген", "НЕК");
            put("Гоу Эхед Иглс", "Гоу Эхед Иглз");
            put("Фортуна", "Фортуна Ситтард");
            put("Йонг Аякс", "Аякс II");
        }
    };

    public static Map<String, String> englandPremierMapping = new HashMap<String, String>(){
        {
            put("Кристал Пэлас", "Кристал Пэлэс");
            put("Бёрнли", "Бернли");
        }
    };

}
