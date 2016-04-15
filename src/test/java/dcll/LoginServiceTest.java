package dcll;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by flori on 15/04/2016.
 */
public class LoginServiceTest {

	private LoginService loginService;

	private final String[] arrayLogin = {"mardup", "thogui", "thoper"};

	@Before
	public void setUp() throws Exception {
		loginService = new LoginService(arrayLogin);
	}

	@Test
	public void testLoginExists() throws Exception {
		final String login = "mardup";
		assertTrue("Test loginExists() : NOK", loginService.loginExists(login));
		System.out.println("Test loginExists() : OK");
	}

	@Test
	public void testAddLogin() throws Exception {
		final String newLogin = "flogar";
		loginService.addLogin(newLogin);
		assertEquals("Test addLogin() : NOK", newLogin, loginService.findAllLogins().get(
				loginService.findAllLogins().size()-1));
		System.out.println("Test addLogin() : OK");
	}

	@Test
	public void testFindAllLoginsStartingWith() throws Exception {
		final String prefixe = "th";
		final List<String> result = loginService.findAllLoginsStartingWith(prefixe);
//		System.out.println(result);
		final String[] expected = {"thogui", "thoper"};
		assertArrayEquals("Test findAllLoginsStartingWith() : NOK", expected, result.toArray());
		System.out.println("Test findAllLoginsStartingWith() : OK");
	}

	@Test
	public void testFindAllLogins() throws Exception {
		final List<String> result = loginService.findAllLogins();
		assertArrayEquals("Test findAllLogins() : NOK", arrayLogin, result.toArray());
		System.out.println("Test findAllLogins() : OK");
	}
}