package org.pitoshnaya.task4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

public class PasswordManagerTest {
    private final PasswordManager passwordManager = new PasswordManager();

    @Test
    public void addPasswordWorksWithoutCollisions() throws Exception {
        var fixtures = new HashMap<String, String>() {{
            put("Johhny", "123qwerty");
            put("Milly", "321654");
            put("sam", "77uuuu");
            put("14Max", "rawrgh1");
            put("117732", "pawned");
        }};

        for (var entry: fixtures.entrySet()) {
            passwordManager.addPassword(entry.getKey(), entry.getValue());
        }

        for (var entry: fixtures.entrySet()) {
            var correctPassword = entry.getValue();
            assertTrue(passwordManager.checkPassword(entry.getKey(), entry.getValue()));

            var wrongPassword = correctPassword + "rand";
            assertFalse(passwordManager.checkPassword(entry.getKey(), wrongPassword));
        }
    }

    @Test
    public void addPasswordThatIsAlreadyThere() {
        var user = new String("Minnie");
        var password = new String("17j123z#S13");

        Exception e = assertThrows(Exception.class, () -> {
            passwordManager.addPassword(user, password);
            passwordManager.addPassword(user, "another password");
        });

        String expectedMessage = "У пользователя уже есть пароль";
        assertEquals(expectedMessage, e.getMessage());

        assertTrue(passwordManager.checkPassword(user, password), "Пароль не должен сбрасываться при неудачной попытке установить новый пароль");
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "       "})
    public void addPasswordValidation(String password) {
        var user = "Minnie";
        Exception e = assertThrows(Exception.class, () -> passwordManager.addPassword(user, password));

        String expectedMessage = "Некорректный пароль";
        assertEquals(expectedMessage, e.getMessage());
        assertFalse(passwordManager.checkPassword(user, password), "Неправильные данные не должны были сохраниться");
    }

    @Test
    public void checkPasswordComparison() throws Exception {
        var user = new String("Minnie");
        var password = new String("17j123z#S13");
        passwordManager.addPassword(user, password);

        assertTrue(passwordManager.checkPassword("Minnie", "17j123z#S13"), "Данные пользователя не подошли, хотя должны были.");
    }
}
