package api;

import io.qameta.allure.Step;
import objects.RequestUser;
import objects.ResponseUser;
import org.testng.Assert;

public class Steps {
    @Step(value = "Проверить пользователя")
    static void checkUser(RequestUser requestUser, ResponseUser responseUser){
        Assert.assertEquals(responseUser.getEmail(), requestUser.getEmail(), "емейл отличается");
        Assert.assertEquals(responseUser.getName(), requestUser.getName(), "имя отличается");
        Assert.assertEquals(responseUser.getHobby(), requestUser.getHobby(), "хобби отличается");
        Assert.assertEquals(responseUser.getPhone(), requestUser.getPhone(), "телефон отличается");
        Assert.assertEquals(responseUser.getInn(), requestUser.getInn(), "инн отличается");
    }

    @Step(value = "Проверить компании пользователя")
    static void checkCompanies(RequestUser requestUser, ResponseUser responseUser){
        Assert.assertEquals(requestUser.getCompanies().size(), responseUser.getCompanies().size(), "количество компаний отличается");
        for (int i = 0; i < requestUser.getCompanies().size(); i++) {
            Assert.assertEquals(requestUser.getCompanies().get(i), responseUser.getCompanies().get(i).id, "id компаний отличается");
            Assert.assertFalse(responseUser.getCompanies().get(i).getName().isEmpty(), "имя компании пустое");
        }
    }
}
