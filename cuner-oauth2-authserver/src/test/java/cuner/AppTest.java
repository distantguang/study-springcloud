package cuner;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Unit test for simple AuthServerApp.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String pwd = new BCryptPasswordEncoder().encode("123456");
        System.out.println(pwd);
        assertTrue( true );
    }
}
