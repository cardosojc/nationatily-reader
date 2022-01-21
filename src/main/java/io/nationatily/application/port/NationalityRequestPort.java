package io.nationatily.application.port;

import io.nationatily.domain.NationalityStats;

import java.util.List;

public interface NationalityRequestPort {
    List<NationalityStats> findNoOfEmployessByNationality();
}
