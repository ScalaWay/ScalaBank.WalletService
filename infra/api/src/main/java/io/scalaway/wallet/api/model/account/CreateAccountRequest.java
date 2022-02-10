/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.model.account;

import io.scalaway.wallet.application.port.usecase.account.command.CreateAccountCommand;
import lombok.Data;

@Data
public class CreateAccountRequest {
    private String name;
    private String seed;
    private String passphrase;
    private String description;

    public static CreateAccountCommand toCommand(CreateAccountRequest request){
        CreateAccountCommand command = new CreateAccountCommand();
        command.setName(request.getName());
        command.setSeed(request.getSeed());
        command.setPassphrase(request.getPassphrase());
        return command;
    }
}
