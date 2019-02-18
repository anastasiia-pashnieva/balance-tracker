package com.pashnieva.website.api.check.service;

import com.pashnieva.website.api.check.dto.Check;
import com.pashnieva.website.api.user.dto.User;

import java.util.List;

public interface CheckService {

    Check getCheck(Long id);
    List<Check> getAllChecks();
    List<Check> getChecksByUser(User user);
    Check createCheck(Check check);
    Check updateCheck(Check check);
    void deleteCheck(Long id);
}
