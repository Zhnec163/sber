package api;

import objects.Users;
import org.apache.commons.lang3.RandomStringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "data", parallel = true)
    public Object[][] dp() {
        Users users = prepareTestData();
        int countUsers = users.getUsers().size();
        Object[][] objects = new Object[countUsers][];
        for (int i = 0; i < countUsers; i++) {
            objects[i] = new Object[] {users.getUsers().get(i)};
        }
        return objects;
    }

    private Users prepareTestData(){
        Users users;
        try {
            users = new ObjectMapper().readValue(getClass().getClassLoader().getResource("users.json"), Users.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        users.getUsers().forEach(e -> {
            e.setEmail(RandomStringUtils.random(10, false, true) + "@mail.com");
            e.setName(RandomStringUtils.random(10, false, true));
        });
        return users;
    }
}
