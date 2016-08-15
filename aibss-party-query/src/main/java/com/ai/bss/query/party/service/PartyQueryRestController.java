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

package com.ai.bss.query.party.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ai.bss.query.api.party.PartyEntry;
import com.ai.bss.query.party.repositories.PartyQueryRepository;

/**
 * @author Lianhua Zhang
 */
@RestController
@RequestMapping("/party")

public class PartyQueryRestController{
	@Autowired
    private PartyQueryRepository partyRepository;
	
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<PartyEntry> get(Model model) {
        return partyRepository.findAll();
    }

    @RequestMapping(value = "/{partyId}", method = RequestMethod.GET)
    public PartyEntry details(@PathVariable String partyId) {
    	return partyRepository.findOne(partyId);
    }
}
