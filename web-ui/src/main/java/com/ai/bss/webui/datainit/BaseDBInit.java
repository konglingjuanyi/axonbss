package com.ai.bss.webui.datainit;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;

import com.ai.bss.api.user.CreateUserCommand;
import com.ai.bss.api.user.UserId;
import com.ai.bss.query.party.repositories.PartyQueryRepository;

/**
 * Base class for all DBInit implementations
 */
public abstract class BaseDBInit implements DBInit {
//    private CommandBus commandBus;
    private PartyQueryRepository partyQueryRepository;

//    protected BaseDBInit(CommandBus commandBus, 
//    		PartyQueryRepository partyQueryRepository
////    		, PortfolioQueryRepository portfolioRepository, OrderBookQueryRepository orderBookRepository
//    		) {
////        this.commandBus = commandBus;
//    }

    @Override
    public void createItems() {
        initializeDB();

        UserId buyer1 = createuser("Buyer One", "buyer1");
        UserId buyer2 = createuser("Buyer two", "buyer2");
        UserId buyer3 = createuser("Buyer three", "buyer3");
        UserId buyer4 = createuser("Buyer four", "buyer4");
        UserId buyer5 = createuser("Buyer five", "buyer5");
        UserId buyer6 = createuser("Buyer six", "buyer6");

        additionalDBSteps();
    }

    UserId createuser(String longName, String userName) {
        UserId userId = new UserId();
        CreateUserCommand createUser = new CreateUserCommand(userId, longName, userName, userName);
//        commandBus.dispatch(new GenericCommandMessage<>(createUser));
        return userId;
    }

    abstract void initializeDB();

    abstract void additionalDBSteps();
}
