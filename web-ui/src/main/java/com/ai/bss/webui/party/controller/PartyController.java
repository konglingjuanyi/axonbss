/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ai.bss.webui.party.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateChildDepartmentCommand;
import com.ai.bss.api.party.command.CreateIndividualCommand;
import com.ai.bss.api.party.command.CreateLegalCommand;
import com.ai.bss.api.party.command.CreateTopDepartmentCommand;
import com.ai.bss.api.party.command.RenameDepartmentCommand;
import com.ai.bss.api.party.command.RenameIndividualCommand;
import com.ai.bss.api.party.command.RenameLegalCommand;
import com.ai.bss.api.party.command.TerminateDepartmentCommand;
import com.ai.bss.api.party.command.TerminateIndividualCommand;
import com.ai.bss.api.party.command.TerminateLegalCommand;
import com.ai.bss.mutitanent.TenantContext;
import com.ai.bss.query.api.party.DepartmentEntry;
import com.ai.bss.query.api.party.IndividualEntry;
import com.ai.bss.query.api.party.LegalOrganizationEntry;
import com.ai.bss.query.api.party.PartyEntry;
import com.ai.bss.webui.party.model.ChildDepartment;
import com.ai.bss.webui.party.model.Department;
import com.ai.bss.webui.party.model.Individual;
import com.ai.bss.webui.party.model.Legal;
import com.ai.bss.webui.party.model.TopDepartment;
import com.ai.bss.webui.util.BaseController;

/**
 * @author Lianhua Zhang
 */
@Controller
@RequestMapping("/party")

public class PartyController extends BaseController{

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("items", client.getForObject("http://party-query-service/party",Iterable.class));
        return "party/list";
    }

    @RequestMapping(value = "/{partyId}", method = RequestMethod.GET)
    public String details(@PathVariable String partyId, Model model) {
        PartyEntry partyEntry = client.getForObject("http://party-query-service/party/"+partyId,PartyEntry.class);
        if(null!=partyEntry){
        	if (partyEntry instanceof IndividualEntry){
        		IndividualEntry individualEntry=(IndividualEntry)partyEntry;
        		Individual individual=new Individual();
        		individual.setPartyId(partyId);
        		individual.setFirstName(individualEntry.getFirstName());
        		individual.setLastName(individualEntry.getLastName());
        		individual.setState(individualEntry.getState());
                model.addAttribute("individual", individual);
                return "party/individualDetail";
        	}else if (partyEntry instanceof LegalOrganizationEntry){
        		LegalOrganizationEntry legalOrganizationEntry = (LegalOrganizationEntry)partyEntry;
        		Legal legal=new Legal();
        		legal.setPartyId(partyId);
        		legal.setLegalName(legalOrganizationEntry.getLegalName());
        		legal.setState(legalOrganizationEntry.getState());
        		model.addAttribute("legal", legal);
        		return "party/legalDetail";
        	}else if (partyEntry instanceof DepartmentEntry){
        		DepartmentEntry departmentEntry = (DepartmentEntry)partyEntry;
        		if(departmentEntry.isTopDepartment()){
        			TopDepartment department=new TopDepartment();
            		department.setPartyId(partyId);
            		department.setLegalId(departmentEntry.getLegalOrganization().getPartyId());
            		department.setLegalName(departmentEntry.getLegalOrganization().getLegalName());
            		department.setDepartmentName(departmentEntry.getDepartmentName());
            		department.setState(departmentEntry.getState());
            		model.addAttribute("topDepartment", department);
            		return "party/topDepartmentDetail";
        		}else{
        			ChildDepartment department=new ChildDepartment();
            		department.setPartyId(partyId);
            		department.setParentDepartmentId(departmentEntry.getParentDepartment().getPartyId());
            		department.setParentDepartmentName(departmentEntry.getParentDepartment().getDepartmentName());
            		department.setDepartmentName(departmentEntry.getDepartmentName());
            		department.setState(departmentEntry.getState());
            		model.addAttribute("topDepartment", department);
            		return "party/childDepartmentDetail";
        		}       		
        	}
        }
        return "party/list";
    }
    
    @RequestMapping(value = "/rename/{partyId}", method = RequestMethod.GET)
    public String rename(@PathVariable String partyId, Model model) {
    	PartyEntry partyEntry = client.getForObject("http://party-query-service/party/"+partyId,PartyEntry.class);
        if(null!=partyEntry){
        	if (partyEntry instanceof IndividualEntry){
        		IndividualEntry individualEntry=(IndividualEntry)partyEntry;
        		Individual individual=new Individual();
        		individual.setPartyId(partyEntry.getPartyId());
        		individual.setFirstName(individualEntry.getFirstName());
        		individual.setLastName(individualEntry.getLastName());
                model.addAttribute("individual", individual);
                return "party/renameIndividual";
        	}else if (partyEntry instanceof LegalOrganizationEntry){
        		LegalOrganizationEntry legalEntry=(LegalOrganizationEntry)partyEntry;
                Legal legal=new Legal();
                legal.setPartyId(legalEntry.getPartyId());
                legal.setLegalName(legalEntry.getLegalName());
        		model.addAttribute("legal", legal);
        		return "party/renameLegal";
        	}else if (partyEntry instanceof DepartmentEntry){
        		DepartmentEntry departmentEntry=(DepartmentEntry)partyEntry;
        		Department department=new Department();
        		department.setPartyId(departmentEntry.getPartyId());
        		department.setDepartmentName(departmentEntry.getDepartmentName());
        		model.addAttribute("department", department);
        		return "party/renameDepartment";
        	}
        }
        return "party/list";
    }
    
    @RequestMapping(value = "/createIndividual", method = RequestMethod.GET)
    public String createIndividualForm(Model model) {
    	Individual individual = new Individual();
        model.addAttribute("individual", individual);
        return "party/createIndividual";
    }
    
    @RequestMapping(value = "/createLegal", method = RequestMethod.GET)
    public String createLegalForm(Model model) {
    	Legal legal = new Legal();
        model.addAttribute("legal", legal);
        return "party/createLegal";
    }

    @RequestMapping(value = "/createTopDepartment/{legalId}", method = RequestMethod.GET)
    public String createTopDepartmentForm(@PathVariable String legalId,Model model) {
    	PartyEntry partyEntry = client.getForObject("http://party-query-service/party/"+legalId,PartyEntry.class);
    	LegalOrganizationEntry legalEntry=(LegalOrganizationEntry)partyEntry;
    	TopDepartment topDepartment = new TopDepartment();
    	topDepartment.setLegalId(legalId);
    	topDepartment.setLegalName(legalEntry.getLegalName());
        model.addAttribute("topDepartment", topDepartment);
        return "party/createTopDepartment";
    }
    
    @RequestMapping(value = "/createChildDepartment/{parentDepartmentId}", method = RequestMethod.GET)
    public String createChildDepartmentForm(@PathVariable String parentDepartmentId,Model model) {
    	PartyEntry partyEntry = client.getForObject("http://party-query-service/party/"+parentDepartmentId,PartyEntry.class);
    	DepartmentEntry parentDepartment= (DepartmentEntry)partyEntry;
    	ChildDepartment childDepartment = new ChildDepartment();
    	childDepartment.setParentDepartmentId(parentDepartmentId);
    	childDepartment.setParentDepartmentName(parentDepartment.getDepartmentName());
        model.addAttribute("childDepartment", childDepartment);
        return "party/createChildDepartment";
    }

    @RequestMapping(value = "/createIndividual", method = RequestMethod.POST)
    public String createIndividual(@ModelAttribute("individual") @Valid Individual individual, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		PartyId partyId=new PartyId();            
    		CreateIndividualCommand command =new CreateIndividualCommand(partyId,individual.getFirstName(),individual.getLastName());
    		command.setTenantId(TenantContext.getCurrentTenant());   				
    		try {
    			command=client.postForObject("http://party-service/party/createIndividualCommand",command,CreateIndividualCommand.class);    
			} catch (Exception e) {
				bindingResult.rejectValue("firstName",
                        "error.createIndividual.failed",
                        e.getCause().getMessage());
			}
    		return "redirect:/party";
    	}
    	return "createIndividual";
    }
    
    @RequestMapping(value = "/createLegal", method = RequestMethod.POST)
    public String createLegal(@ModelAttribute("legal") @Valid Legal legal, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		PartyId partyId=new PartyId();
    		CreateLegalCommand command =new CreateLegalCommand(partyId,legal.getLegalName());
    		command.setTenantId(TenantContext.getCurrentTenant());  		
    		try {
    			command=client.postForObject("http://party-service/party/createLegalCommand",command,CreateLegalCommand.class);
			} catch (Exception e) {
				bindingResult.rejectValue("legalName",
                        "error.createLegal.failed",
                        e.getCause().getMessage());
			}
    		return "redirect:/party";
    	}
    	return "createLegal";
    }
    
    @RequestMapping(value = "/createTopDepartment/createTopDepartment", method = RequestMethod.POST)
    public String createTopDepartment(@ModelAttribute("topDepartment") @Valid TopDepartment topDepartment, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		PartyId partyId=new PartyId();
    		CreateTopDepartmentCommand command =new CreateTopDepartmentCommand(partyId,topDepartment.getDepartmentName(),topDepartment.getLegalId());
    		command.setTenantId(TenantContext.getCurrentTenant());
    		command=client.postForObject("http://party-service/createTopDepartmentCommand",command,CreateTopDepartmentCommand.class);
    		//commandBus.dispatch(new GenericCommandMessage<CreateTopDepartmentCommand>(command));
    		return "redirect:/party";
    	}
    	return "createTopDepartment";
    }
    
    @RequestMapping(value = "/createChildDepartment/createChildDepartment", method = RequestMethod.POST)
    public String createChildDepartment(@ModelAttribute("childDepartment") @Valid ChildDepartment childDepartment, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		PartyId partyId=new PartyId();
    		CreateChildDepartmentCommand command =new CreateChildDepartmentCommand(partyId,childDepartment.getDepartmentName(),childDepartment.getParentDepartmentId());
    		command.setTenantId(TenantContext.getCurrentTenant());
    		return "redirect:/party";
    	}
    	return "createChildDepartment";
    }
    
    @RequestMapping(value = "/rename/renameIndividual", method = RequestMethod.POST)
    public String renameIndividual(@ModelAttribute("individual") @Valid Individual individual, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		PartyId partyId=new PartyId(individual.getPartyId());
    		PartyEntry partyEntry = client.getForObject("http://party-query-service/party/"+partyId,PartyEntry.class);
    		IndividualEntry individualEntry = (IndividualEntry)partyEntry;
            if(null!=individualEntry){
            	RenameIndividualCommand command =new RenameIndividualCommand(partyId,individual.getFirstName(),individual.getLastName());
            	command.setOldFirstName(individualEntry.getFirstName());
            	command.setOldLastName(individualEntry.getLastName());            	
            	command.setTenantId(TenantContext.getCurrentTenant());
        		try {
        			command=client.postForObject("http://party-service/party/RenameIndividualCommand",command,RenameIndividualCommand.class);
        			return "redirect:/party";
    			} catch (Exception e) {
    				bindingResult.rejectValue("firstName",
                            "error.renameIndividual.notChanged",
                            e.getCause().getMessage());
    			}
            }    		   		    		
    	}
    	return "party/renameIndividual";
    }
    
    @RequestMapping(value = "/rename/renameLegal", method = RequestMethod.POST)
    public String renameLegal(@ModelAttribute("legal") @Valid Legal legal, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		PartyId partyId=new PartyId(legal.getPartyId());
    		PartyEntry partyEntry = client.getForObject("http://party-query-service/party/"+partyId,PartyEntry.class);
            if(null!=partyEntry&&(partyEntry instanceof LegalOrganizationEntry)){
        		RenameLegalCommand command =new RenameLegalCommand(partyId,legal.getLegalName());
            	command.setOldLegalName(partyEntry.getName());          	              	
            	command.setTenantId(TenantContext.getCurrentTenant());
        		try {
        			command=client.postForObject("http://party-service/party/RenameLegalCommand",command,RenameLegalCommand.class);
        			return "redirect:/party";
    			} catch (Exception e) {
    				bindingResult.rejectValue("legalName",
                            "error.renameLegal.notChanged",
                            e.getCause().getMessage());
    			}                		
            }    		   		    		
    	}
    	return "party/renameLegal";
    }
    
    @RequestMapping(value = "/rename/renameDepartment", method = RequestMethod.POST)
    public String renameDepartment(@ModelAttribute("department") @Valid Department department, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		PartyId partyId=new PartyId(department.getPartyId());
    		PartyEntry partyEntry = client.getForObject("http://party-query-service/party/"+partyId,PartyEntry.class);
            if(null!=partyEntry&&(partyEntry instanceof DepartmentEntry)){
        		RenameDepartmentCommand command =new RenameDepartmentCommand(partyId,department.getDepartmentName());
        		command.setOldDepartmentName(partyEntry.getName());          	              	
        		command.setTenantId(TenantContext.getCurrentTenant());
        		try {
        			command=client.postForObject("http://party-service/party/RenameDepartmentCommand",command,RenameDepartmentCommand.class);
        			return "redirect:/party";
    			} catch (Exception e) {
    				bindingResult.rejectValue("departmentName",
                            "error.renameDepartment.notChanged",
                            e.getCause().getMessage());
    			}    		
            }    		   		    		
    	}
    	return "party/renameDepartment";
    }
    
    @RequestMapping(value = "/terminate/{partyId}", method = RequestMethod.POST)
    public String terminateIndividual(@PathVariable String partyId, Model model) {
    	try {
    		PartyEntry partyEntry = client.getForObject("http://party-query-service/party/"+partyId,PartyEntry.class);
	        if(null!=partyEntry){
	        	if (partyEntry instanceof IndividualEntry){
	        		TerminateIndividualCommand command =new TerminateIndividualCommand(new PartyId(partyId));
	        		command.setTenantId(TenantContext.getCurrentTenant());
	        		command=client.postForObject("http://party-service/party/TerminateIndividualCommand",command,TerminateIndividualCommand.class);
	        	}else if (partyEntry instanceof LegalOrganizationEntry){
	        		TerminateLegalCommand command =new TerminateLegalCommand(new PartyId(partyId));
	        		command.setTenantId(TenantContext.getCurrentTenant());
	        		command=client.postForObject("http://party-service/party/TerminateLegalCommand",command,TerminateLegalCommand.class);
	        	}else{
	        		TerminateDepartmentCommand command =new TerminateDepartmentCommand(new PartyId(partyId));
	        		command.setTenantId(TenantContext.getCurrentTenant());
	        		command=client.postForObject("http://party-service/party/TerminateDepartmentCommand",command,TerminateDepartmentCommand.class);
	        	}
	        }
    		
    		return "redirect:/party";
		} catch (Exception e) {
			e.printStackTrace();
		}
    		
    	return "terminate/"+partyId;
    }

}
