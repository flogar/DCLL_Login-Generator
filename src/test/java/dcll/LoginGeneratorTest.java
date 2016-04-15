package dcll;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by flori on 15/04/2016.
 */
public class LoginGeneratorTest {

	private LoginGenerator loginGenerator;
	private LoginService loginService;
	private String[] arrayLogins = new String[] {
			"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"
	};

	@Before
	public void setUp() throws Exception {
		loginService = new LoginService(arrayLogins);
		loginGenerator = new LoginGenerator(loginService);
	}

	@Test
	public void testGenerateLoginForNomAndPrenomCasSimple() throws Exception {
		final String prenom = "Paul";
		final String nom = "Durand";
		final String loginExpected = "PDUR";
		loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
		assertTrue("Test generateLoginForNomAndPrenom() - Cas simple : NOK",
				loginService.loginExists(loginExpected));
		System.out.println("Test generateLoginForNomAndPrenom() - Cas simple : OK");
	}

	@Test
	public void testGenerateLoginForNomAndPrenomCasDoublon() throws Exception {
		final String prenom = "Jean";
		final String nom = "Rolling";
		final String loginExpected = "JROL1";
		loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
		assertTrue("Test generateLoginForNomAndPrenom() - Cas doublon : NOK",
				loginService.loginExists(loginExpected));
		System.out.println("Test generateLoginForNomAndPrenom() - Cas doublon : OK");
	}

	@Test
	public void testGenerateLoginForNomAndPrenomCasAccent() throws Exception {
		final String prenom = "Paul";
		final String nom = "Dùrand";
		final String loginExpected = "PDUR";
		loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
		assertTrue("Test generateLoginForNomAndPrenom() - Cas accent : NOK",
				loginService.loginExists(loginExpected));
		System.out.println("Test generateLoginForNomAndPrenom() - Cas accent : OK");
	}

	@Test
	public void testGenerateLoginForNomAndPrenomCasTropCourt() throws Exception {
		final String prenom = "Paul";
		final String nom = "Du";
		final String loginExpected = "PDU";
		loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
		assertTrue("Test generateLoginForNomAndPrenom() - Cas trop court : NOK",
				loginService.loginExists(loginExpected));
		System.out.println("Test generateLoginForNomAndPrenom() - Cas trop court : OK");
	}

	@Test
	public void testGenerateLoginForNomAndPrenomCasTriplet() throws Exception {
		final String prenom = "John";
		final String nom = "Ralling";
		final String loginExpected = "JRAL2";
		loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
		assertTrue("Test generateLoginForNomAndPrenom() - Cas triplet : NOK",
				loginService.loginExists(loginExpected));
		System.out.println("Test generateLoginForNomAndPrenom() - Cas triplet : OK");
	}
}