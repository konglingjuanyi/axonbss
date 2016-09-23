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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.api.customer.CustomerId;
import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.customerorder.command.StartBuyOrderCommand;
import com.ai.bss.api.policy.PolicyId;
import com.ai.bss.api.policy.command.CreateAtomicPolicyCommand;
import com.ai.bss.api.policy.command.RegisterNewAtomicPolicyToCommand;
import com.ai.bss.api.policy.dto.AtomicAction;
import com.ai.bss.api.policy.dto.AtomicCondition;
import com.ai.bss.api.policy.dto.AtomicPolicy;
import com.ai.bss.api.policy.dto.ConstValue;
import com.ai.bss.api.policy.dto.ValuePan;
import com.ai.bss.api.policy.dto.Variable;
import com.ai.bss.api.policy.dto.VariablePan;
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
	private URL orderServiceURL;
	private URL policyServiceURL;
	@Autowired
	private RestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		//this.orderServiceURL = new URL("http://customerorder-service/customerorder/startBuyOrderCommand");
		this.policyServiceURL = new URL("http://po0licy-service/policy/createAtomicPolicyCommand");
	}
	
	@Test
	public void testCreatePolicy(){
		CreateAtomicPolicyCommand command = new CreateAtomicPolicyCommand();
		PolicyId policyId = new PolicyId();
		AtomicPolicy policy=new AtomicPolicy();
		policy.setPolicyId(policyId.toString());
		policy.setCode("CustomerLevelMustMoreThan1");
		AtomicCondition condition = new AtomicCondition();
		condition.setCode("CustomerLevelMoreThan1");
		condition.setName("Customer Level More Than1");
		VariablePan left =new VariablePan();
		Variable variable= new Variable();
		variable.setCode("CustomerLevel");
		variable.setName("Customer Level");
		variable.setType("String");
		left.setVariable(variable);
		ValuePan right = new ValuePan();
		ConstValue value= new ConstValue();
		value.setCode("1");
		value.setCode("one");
		value.setType("int");
		value.setValue("1");
		right.setValue(value);
		condition.setLeft(left);
		condition.setOperator(">");
		condition.setRight(right);
		policy.setCondition(condition);
		AtomicAction action = new AtomicAction();
		Variable returnValueVariable= new Variable();
		returnValueVariable.setCode("retResult");
		returnValueVariable.setName("return result");
		returnValueVariable.setType("boolean");
		VariablePan actionLeft =new VariablePan();
		actionLeft.setVariable(returnValueVariable);
		ValuePan actionRight = new ValuePan();
		ConstValue actionValue= new ConstValue();
		actionValue.setCode("true");
		actionValue.setCode("true");
		actionValue.setType("boolean");
		actionValue.setValue("true");
		actionRight.setValue(actionValue);
		action.setLeft(actionLeft);
		action.setOperator("=");
		action.setRight(actionRight);
		policy.setAction(action);
		command.setPolicy(policy);
		command.setPolicyId(policyId);
		command=restTemplate.postForEntity(policyServiceURL.toString(), command,CreateAtomicPolicyCommand.class).getBody();
		RegisterNewAtomicPolicyToCommand registerCommand = new RegisterNewAtomicPolicyToCommand();
		registerCommand.setCommandName("StartBuyOrderCommand");
		registerCommand.setCommandPropertyName("OfferingId");
		registerCommand.setCommandPropertyValue("1011");
		registerCommand.setPolicy(policy);
		registerCommand.setPolicyId(policyId);
		registerCommand=restTemplate.postForEntity(policyServiceURL.toString(), registerCommand,RegisterNewAtomicPolicyToCommand.class).getBody();		
	}

	//@Test
	public void testBuy() throws Exception {
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
		command=restTemplate.postForEntity(orderServiceURL.toString(), command,StartBuyOrderCommand.class).getBody();
	}

}
