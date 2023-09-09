package balachonov.services;

import balachonov.dto.responses.PersonArchiveResponse;

public interface PersonArchiveService {
    void toArchive(PersonArchiveResponse personArchiveResponse);
}