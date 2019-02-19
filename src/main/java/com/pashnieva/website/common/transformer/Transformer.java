package com.pashnieva.website.common.transformer;

import java.util.Map;

public interface Transformer<S, T> {

    T transform(S source);
    T transform(S source, Map<String, Object> params);
}
