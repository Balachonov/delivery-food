package balachonov.services;

import balachonov.dto.responses.PersonArchiveResponse;

public interface PersonArchiveService {

    /**
     * Sending person data to the remote API archive database
     */
    void toArchive(PersonArchiveResponse personArchiveResponse);
}