package api;

import objects.RequestUser;
import objects.ResponseUser;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;
@Test(dataProvider = "data",
        dataProviderClass = Data.class,
        suiteName = "API",
        testName = "Создание пользователя")
public class UserTest {

    public void createUserTest(RequestUser requestUser){
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification());
        ResponseUser responseUser = given()
                .body(requestUser)
                .when()
                .post("tasks/rest/createuser")
                .then()
                .extract().body().as(ResponseUser.class);

        Steps.checkUser(requestUser, responseUser);
        Steps.checkCompanies(requestUser, responseUser);
    }
}
