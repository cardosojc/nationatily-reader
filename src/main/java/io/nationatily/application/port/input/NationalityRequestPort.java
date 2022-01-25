package io.nationatily.application.port.input;

import io.nationatily.domain.NationalityStats;

import java.util.List;

public interface NationalityRequestPort {
    List<NationalityStats> findNoOfEmployessByNationality();
}
