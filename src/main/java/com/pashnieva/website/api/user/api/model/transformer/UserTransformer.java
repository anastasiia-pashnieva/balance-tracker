package com.pashnieva.website.api.user.api.model.transformer;

import com.pashnieva.website.api.user.dto.User;
import com.pashnieva.website.common.transformer.DtoTransformer;

public interface UserTransformer<S> extends DtoTransformer<S, User> {

    User transform(S source);
}
