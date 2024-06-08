package user_crud_integeration_tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.user_cruds.UserCRUDOperations;

import static org.testng.Assert.*;

public class UserCRUDsTests {

    @Test
    public void testCreateUser() {
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = UserCRUDOperations.createNewUser(requestBody);

        assertEquals(response.statusCode(), 201);
        assertEquals(response.jsonPath().get("name"), "morpheus");
        assertEquals(response.jsonPath().get("job"), "leader");
        assertTrue(response.jsonPath().getInt("id") > 0);
        assertNotEquals(response.jsonPath().get("createdAt"), "");
        assertNotNull(response.jsonPath().get("createdAt"));


    }

    @Test
    public void testUpdateUserNo2() {
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = UserCRUDOperations.updateUser(requestBody, 2);

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().get("name"), "morpheus");
        assertEquals(response.jsonPath().get("job"), "zion resident");
        assertNotEquals(response.jsonPath().get("createdAt"), "");
        assertNotNull(response.jsonPath().get("updatedAt"));


    }

    @Test
    public void testListUsersInPageNo2() {
        Response response = UserCRUDOperations.listUsersInPage(2);

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getInt("page"), 2);
        assertEquals(response.jsonPath().getInt("per_page"), 6);
        assertEquals(response.jsonPath().getInt("total"), 12);
        assertEquals(response.jsonPath().getInt("total_pages"), 2);

        // Number of users should be 6
        assertEquals(response.jsonPath().getList("data").size(), 6);

        int[] expectedIds = {7, 8, 9, 10, 11, 12};
        String[] expectedEmails = {
                "michael.lawson@reqres.in",
                "lindsay.ferguson@reqres.in",
                "tobias.funke@reqres.in",
                "byron.fields@reqres.in",
                "george.edwards@reqres.in",
                "rachel.howell@reqres.in"
        };

        for (int i = 0; i < expectedIds.length; i++) {
            assertEquals(response.jsonPath().getInt("data[" + i + "].id"), expectedIds[i]);
            assertEquals(response.jsonPath().getString("data[" + i + "].email"), expectedEmails[i]);
        }


    }


}
