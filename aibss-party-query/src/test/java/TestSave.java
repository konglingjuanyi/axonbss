import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.bss.api.party.PartyId;
import com.ai.bss.query.party.IndividualEntry;
import com.ai.bss.query.party.PartyQueryServiceApp;
import com.ai.bss.query.party.repositories.PartyQueryRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PartyQueryServiceApp.class)
public class TestSave {
	@Autowired
	private PartyQueryRepository partyRepository;
	@Test
	public void testSave() throws Exception {
		//PartyId partyId=new PartyId();
		IndividualEntry partyEntry = new IndividualEntry("Levon","Zhang");
		partyEntry.setPartyId("1111");
    	partyEntry.setState("initial");
        partyRepository.save(partyEntry);
	}

}
