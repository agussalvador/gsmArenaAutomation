package com.solvd.gsmarena.tests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.gsmarena.HomePage;
import com.solvd.gsmarena.services.ISearchService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchTests implements IAbstractTest, ISearchService {

    @Test
    public void ValidateGeneralSearching() {
        HomePage homePage = search(getDriver(), "Samsung");
        assertEquals(homePage.getSearchResultTitle(), "Search results for \"Samsung\"", "FATAL! not same");
    }

    @Test
    public void ValidateSpecificSearching() {
        HomePage homePage = search(getDriver(), "a72");
        assertEquals(homePage.getSearchResultTitle(), "Search results for \"a72\"", "FATAL! not same");
    }

}
