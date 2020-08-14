import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class OauthTest {



    @Test
    public void oauthte(){
        String passWord = "3";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        passWord = encoder.encode(passWord);
        System.out.println(passWord);
    }
}
