package ru.pavel2107.tests.suitablesoftdemo.comparator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import ru.pavel2107.tests.suitablesoftdemo.service.finder.QuickSelectElementFinderImpl;

import static org.junit.jupiter.api.Assertions.*;

@Import( {QuickSelectElementFinderImpl.class})
@DisplayName( "Test QuickSelect")
class QuickSelectElementFinderImplTest {

    @Test
    void findLargest() {

        int []arr = new int[]{1, 2, 3, 35, 20, 30};
        int n = 2;

        //
        // я не хочу проверять привязку, мне интересен только функционал данного класса, поэтому делаю экземпляр
        //
        QuickSelectElementFinderImpl finder = new QuickSelectElementFinderImpl();

        int max = finder.findLargest( arr, n);
        assertEquals( 30, max);

    }
}