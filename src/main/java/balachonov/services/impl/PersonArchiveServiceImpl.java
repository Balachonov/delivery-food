package balachonov.services.impl;

import balachonov.dto.responses.PersonArchiveResponse;
import balachonov.feingClients.PersonArchiveClient;
import balachonov.services.PersonArchiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonArchiveServiceImpl implements PersonArchiveService {

    private final PersonArchiveClient personArchiveClient;

    @Override
    public void toArchive(PersonArchiveResponse personArchiveResponse) {
        personArchiveClient.savePersonArchive(personArchiveResponse);
    }
}