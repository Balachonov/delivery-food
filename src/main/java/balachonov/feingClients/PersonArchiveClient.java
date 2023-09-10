package balachonov.feingClients;

import balachonov.dto.responses.PersonArchiveResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "archive-server/archive/person")
public interface PersonArchiveClient {

    /**
     * Sending person data to the remote API archive database
     */
    @PostMapping
    void savePersonArchive(PersonArchiveResponse personArchiveResponse);
}