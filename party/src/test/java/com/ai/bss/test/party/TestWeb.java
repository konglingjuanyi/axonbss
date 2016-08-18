package com.ai.bss.test.party;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.net.URL;

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

import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateIndividualCommand;
import com.ai.bss.service.party.PartyApiService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PartyApiService.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8089"})
public class TestWeb {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:8089/party/createIndividualCommand");
		template = new TestRestTemplate();
	}

	@Test
	public void getHello() throws Exception {
		PartyId partyId=new PartyId();
		CreateIndividualCommand command=new CreateIndividualCommand(partyId,"Alex","Choi");
		//ResponseEntity<String> response = template.postForEntity(base.toString(), command,String.class);
		command = template.postForObject("http://localhost:8089/party/createIndividualCommand",command,CreateIndividualCommand.class);
		assertThat(command.getFirstName().equalsIgnoreCase("Alex"), is(true));
	}

}
