package ru.pavel2107.tests.suitablesoftdemo.service.processor;

import java.io.InputStream;
import java.util.List;

public interface XlsProcessor {

    List<Integer> read(InputStream stream) throws Exception;
}
