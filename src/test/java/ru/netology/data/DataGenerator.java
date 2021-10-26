package ru.netology.data;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    public DataGenerator() {
    }

    private Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationInfo generate(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationInfo(
                    faker.address().city(),
                    LocalDate.now().plusDays(3),
                    faker.name().lastName() + " " + faker.name().firstName(),
                    faker.phoneNumber().phoneNumber());
        }

        public static String generateDate(int days) {
            return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String generateCity() {
            Random random = new Random();
            int rand = random.nextInt(5);
            String cities[] = {"Москва", "Санкт-Петербург", "Владивосток", "Брянск", "Севастополь"};
            return cities[rand];
        }
    }
}