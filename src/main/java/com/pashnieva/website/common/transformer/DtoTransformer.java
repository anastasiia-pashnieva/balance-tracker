package com.pashnieva.website.common.transformer;

public interface DtoTransformer<S, T> {

    T transform(S source);
}
