package com.ai.bss.test.webui;

import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.api.customer.CustomerId;
import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.customerorder.command.StartBuyOrderCommand;
import com.ai.bss.api.product.dto.BuyOffer;
import com.ai.bss.api.product.dto.Price;
import com.ai.bss.api.product.dto.Product;
import com.ai.bss.webui.AiBssWebApplication;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AiBssWebApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class WebTest {

	public WebTest() {
		// TODO Auto-generated constructor stub
	}
	private URL base;
	@Autowired
	private RestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://customerorder-service/customerorder/startBuyOrderCommand");
	}

	@Test
	public void getHello() throws Exception {
		StartBuyOrderCommand command = new StartBuyOrderCommand();
		CustomerOrderId customerOrderId = new CustomerOrderId();
		command.setCustomerOrderId(customerOrderId);
		command.setCustomerId(new CustomerId("111"));
		BuyOffer iPhone7offer = new BuyOffer();
		iPhone7offer.setProductOfferingId("1011");
		Price oneTimeFee = new Price();
		oneTimeFee.setPriceSpecificationId("30001");
		oneTimeFee.setUnitPrice(10000);		
		iPhone7offer.addOneTimeFee(oneTimeFee);
		Product iPhone7=new Product();
		iPhone7.setProductSpecificationId("20001");
		iPhone7offer.addProduct(iPhone7);
		Set<BuyOffer> offers =new LinkedHashSet<>();
		offers.add(iPhone7offer);
		BuyOffer iPhone5Soffer = new BuyOffer();
		iPhone5Soffer.setProductOfferingId("1012");
		Price oneTimeFee2 = new Price();
		oneTimeFee2.setPriceSpecificationId("30002");
		oneTimeFee2.setUnitPrice(3000);		
		iPhone5Soffer.addOneTimeFee(oneTimeFee2);
		Product iPhone5S=new Product();
		iPhone5S.setProductSpecificationId("20001");
		iPhone5Soffer.addProduct(iPhone5S);
		command.setOffers(offers);		
		restTemplate.postForEntity(base.toString(), command,StartBuyOrderCommand.class);
	}

}
