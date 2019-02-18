package com.pashnieva.website.api.check.repository;

import com.pashnieva.website.api.check.dto.Check;
import com.pashnieva.website.api.user.dto.User;

import java.util.List;

/*@Repository*/
public interface CheckRepository /*extends JpaRepository<Check, Long> */{

    List<Check> findByUser(User user);
}
