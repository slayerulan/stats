package com.savik.parser.coeffs.x1stavka;


import java.util.HashMap;
import java.util.Map;

public class Book1xbetConstants {
    public static final String URL = "https://1xcwy.top/LineFeed/GetChampZip?lng=ru&tf=3000000&afterDays=0&tz=0&sport=2&country=1&champ=";
    public static final String EVENT_URL = "https://1xcwy.top/LineFeed/GetGameZip?lng=ru&cfview=0&isSubGames=true&GroupEvents=true&countevents=1500&grMode=2&id=";
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
    public static final String FRANCE_2 = URL + "12829";
    public static final String HOLLAND_1 = URL + "35677";
    public static final String HOLLAND_EREDIVISIE = URL + "119575";
    public static final String ENGLAND_PREMIER = URL + "88637";
    public static final String GREECE_SUPERLIGA = URL + "8777";
    public static final String CYPRUS_1 = URL + "12505";
    public static final String COSTA_RICA = URL + "28665";
    public static final String BELGIUM = URL + "28787";

    // hockey

    public static Map<String, String> khlMapping = new HashMap<String, String>() {
        {
            put("Куньлунь РС", "Красная Звезда Куньлунь");
            put("Спартак Москва", "Спартак");
            put("Витязь Подольск", "Витязь");
        }
    };

    public static Map<String, String> extraMapping = new HashMap<String, String>() {
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

    public static Map<String, String> delMapping = new HashMap<String, String>() {
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

    public static Map<String, String> shlMapping = new HashMap<String, String>() {
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

    public static Map<String, String> portugalPremierMapping = new HashMap<String, String>() {
        {
            put("Пасуш де Феррейра", "Пасуш Феррейра");
            put("Маритиму", "Маритимо");
            put("Портимоненси", "Портимоненсе");
            put("Риу Аве", "Риу-Аве");
            put("Морейренси", "Морейренсе");
            put("Сетубал", "Витория Сетубал");
            put("Порту", "Порто");
        }
    };

    public static Map<String, String> indiaSuperligaMapping = new HashMap<String, String>() {
        {
            put("Дели Динамос", "Дели Дайнамос");
            put("Jamshedpur", "Джамшедпур");
            put("Норт-Ист Юнайтед", "Нортист Юнайтед");
            put("ATK", "Атлетико де Калькутта");
            put("Бангалор", "Бенгалуру");
            put("Мумбаи Сити", "Мумбай Сити");
        }
    };

    public static Map<String, String> bundesligaMapping = new HashMap<String, String>() {
        {
            put("Айнтрахт Ф", "Айнтрахт");
            put("РБ Лейпциг", "Лейпциг");
            put("Боруссия Д", "Боруссия");
        }
    };

    public static Map<String, String> holland1Mapping = new HashMap<String, String>() {
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

    public static Map<String, String> hollandSuperligaMapping = new HashMap<String, String>() {
        {
            put("АЗ Алкмар", "АЗ");
            put("Бреда", "НАК");
        }
    };

    public static Map<String, String> englandPremierMapping = new HashMap<String, String>() {
        {
            put("Кристал Пэлас", "Кристал Пэлэс");
            put("Бёрнли", "Бернли");
        }
    };

    public static Map<String, String> france2Mapping = new HashMap<String, String>() {
        {
            put("Кевийи Руан", "ЮС Квевилли");
            put("ФК Париж", "Париж");
            put("Газелек Аяччо", "Газелек");
        }
    };

    public static Map<String, String> greeceSuperligaMapping = new HashMap<String, String>() {
        {
            put("ПАС Янина", "ПАС Джаннина");
            put("Левадиакос", "Левадеякос");
        }
    };

    public static Map<String, String> cyprusMapping = new HashMap<String, String>() {
        {
            put("Алки Ороклини", "Альки Ороклинис");
            put("Олимпиакос Никосия", "Олимпиакос Никосиа");
        }
    };

    public static Map<String, String> belgiumMapping = new HashMap<String, String>() {
        {
            put("Васланд-Беверен", "Васланд");
            put("Синт-Трёйден", "Сент-Трюйден");
            put("Зюльте-Варегем", "Зульте-Варегем");
        }
    };

}
