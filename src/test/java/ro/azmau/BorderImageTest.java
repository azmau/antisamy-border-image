package ro.azmau;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.jupiter.api.Test;
import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import org.owasp.validator.html.ScanException;

class BorderImageTest {

	@Test
	final void testXSSManagerBorderImage3() throws ScanException, PolicyException {

		CleanResults result = antiSamy()
				.scan("<strong><span style=\"padding: 0in; border: 1pt windowtext; border-image: url(border.png); text-transform: uppercase;\"><span style=\"font-size: 10pt;\"><span style=\"font-family: cambria,serif;\"><span style=\"color: rgb(51, 51, 51);\">PRIVACY NOTICE </span></span></span></span></strong><br />");
		assertFalse(result.getErrorMessages().isEmpty());
	}

	private AntiSamy antiSamy() throws PolicyException {
		URL realPath = BorderImageTest.class.getResource("/antisamy/antisamy.xml");

		try (InputStream openStream = realPath.openStream()) {
			Policy policy = Policy.getInstance(openStream);
			return new AntiSamy(policy);
		}
		catch (IOException e) {
			throw new IllegalStateException("Missing policy files");
		}
	}
}
