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

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateIndividualCommand;
import com.ai.bss.query.party.IndividualEntry;
import com.ai.bss.query.party.PartyEntry;
import com.ai.bss.query.party.repositories.PartyQueryRepository;
import com.ai.bss.query.user.repositories.UserQueryRepository;
import com.ai.bss.webui.party.model.Individual;
import com.ai.bss.webui.party.model.Party;

/**
 * @author Jettro Coenradie
 */
@Controller
@RequestMapping("/party")
public class PartyController {

    private PartyQueryRepository partyRepository;
    private UserQueryRepository userRepository;
    private CommandBus commandBus;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public PartyController(PartyQueryRepository partyRepository,
                             CommandBus commandBus,
                             UserQueryRepository userRepository) {
        this.partyRepository = partyRepository;
        this.commandBus = commandBus;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("items", partyRepository.findAll());
        //model.addAttribute("items", partyRepository.findByType("INDIVIDUAL"));
        return "party/list";
    }

    @RequestMapping(value = "/{partyId}", method = RequestMethod.GET)
    public String details(@PathVariable String partyId, Model model) {
        PartyEntry partyEntry = partyRepository.findOne(partyId);
        if(null!=partyEntry){
        	if (partyEntry instanceof IndividualEntry){
        		IndividualEntry individualEntry=(IndividualEntry)partyEntry;
        		Individual individual=new Individual();
        		individual.setPartyId(partyEntry.getPartyId());
        		individual.setFirstName(individualEntry.getFirstName());
        		individual.setLastName(individualEntry.getLastName());
        		individual.setState(individualEntry.getState());
                model.addAttribute("individual", individual);
                return "party/individualDetail";
        	}else{
        		return "party/organizationDetail";
        	}
        }
        return "party";
    }
    
    @RequestMapping(value = "/createIndividual", method = RequestMethod.GET)
    public String createIndividualForm(Model model) {
    	Individual individual = new Individual();
        model.addAttribute("individual", individual);
        return "party/createIndividual";
    }

    @RequestMapping(value = "/createIndividual", method = RequestMethod.POST)
    public String createIndividual(@ModelAttribute("Individual") @Valid Individual individual, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		PartyId partyId=new PartyId();
    		CreateIndividualCommand command =new CreateIndividualCommand(partyId,individual.getFirstName(),individual.getLastName());
    		commandBus.dispatch(new GenericCommandMessage<CreateIndividualCommand>(command));
    		return "redirect:/party";
    	}
    	return "createIndividual";
    }

}
