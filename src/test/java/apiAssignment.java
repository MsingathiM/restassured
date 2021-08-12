import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import java.util.List;
import static io.restassured.RestAssured.*;


public class apiAssignment {

    final static String
            url = "http://localhost:3000";


    public static void main(String args[]) {

        getSpecificUser();
        getPostsByUser();
        getPostComments();
    }

    public static void getSpecificUser() {

        System.out.println("===============Returning User Delphine==================");


        given().when().get(url + "/users/username=Delphine").then().log()
                .body();

        given().queryParam("username", "Delphine")
                .get("http://localhost:3000/users/")
                .then()
                .log()
                .body();
    }

    public static void getPostsByUser() {
        System.out.println("===============Posts By User==================");

        given().when().get(url + "/users/9/posts").then().log()
                .body();

        given().queryParam("id", "9")
                .get("http://localhost:3000/users/9/posts/")
                .then()
                .log()
                .body();
    }

    public static void getPostComments() {
        System.out.println("===============Comments By User==================");


        given().when().get(url + "/posts/9/comments").then().log()
                .body();

        Response res = given().when().get(url + "/posts/9/comments");
        List<String> jsonRes = res.jsonPath().getList("email");

        if (jsonRes.contains(jsonRes)) {

            given().queryParam("id", "9")
                    .get("http://localhost:3000/posts/9/comments/")
                    .then()
                    .assertThat()
                    .body("email", hasItem("Lucio@gladys.tv"))
                    .log()
                    .body();

        }

    }
}
