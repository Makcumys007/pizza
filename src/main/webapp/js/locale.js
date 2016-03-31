function forwardLocale(locale) {
    if (locale == "ru_RU") {
        window.location = "/do/locale?locale=" + locale;
    } else if (locale == "en_US") {
        window.location = "/do/locale?locale=" + locale;
    }

}