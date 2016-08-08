

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.webui.AiBssWebApplication;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AiBssWebApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})
public class TestWeb {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:8080/party/create");
		template = new TestRestTemplate();
	}

	@Test
	public void getHello() throws Exception {
		Map<String, String> urlVariables=new HashMap<String, String>();
		urlVariables.put("firstName", "Levon");
		urlVariables.put("lastName", "Zhang");
		ResponseEntity<String> response = template.postForEntity(base.toString(), urlVariables,String.class);
		assertThat(response.getBody(), is("Levon Zhang"));
	}

}
