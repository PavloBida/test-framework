package selenide_pageobject;

/**
 * Created by Pavlo Bida in 2017
 * https://github.com/PavloBida
 */

public interface IPageLoaded {

    /**
     * Each page must have an element, which indicates that it's loaded.
     * @return
     */
    boolean isPageLoaded();

}
