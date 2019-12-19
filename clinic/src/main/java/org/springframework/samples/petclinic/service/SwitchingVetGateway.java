package org.springframework.samples.petclinic.service;

import org.springframework.context.annotation.Primary;
import org.springframework.samples.petclinic.vets.SameProcessVetGateway;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Primary
public class SwitchingVetGateway implements VetGateway {

    private final SameProcessVetGateway sameProcessVetGateway;
    private final RestVetGateway restVetGateway;

    public SwitchingVetGateway(SameProcessVetGateway sameProcessVetGateway, RestVetGateway restVetGateway) {
        this.sameProcessVetGateway = sameProcessVetGateway;
        this.restVetGateway = restVetGateway;
    }

    @Override
    public Collection<VetDto> vetList() {
        // TODO Strategien
        if (useOtherService()) {
            return restVetGateway.vetList();
        } else {
            return sameProcessVetGateway.vetList();
        }
    }

    private boolean useOtherService() {
        return false;
        // use 1% of traffic
    }
}