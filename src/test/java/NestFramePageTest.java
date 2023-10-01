import org.testng.annotations.Test;
import other.BaseTestClass;
import other.NestFramePage;


public class NestFramePageTest extends BaseTestClass {

    @Test
    public void test_1() {
        var page = NestFramePage.newPage(testWebDriver);
//        System.out.println(page.getCurrentFrameText());
//        for(var nav : new String[]{"middle", "right"}) {
            page.switchFrameTo("o");
//            System.out.println(page.getCurrentFrameText());
//        }
//        page.switchFrameTo(other.NestFramePage.FRAME_OPTION.MIDDLE);
//        System.out.println(page.getCurrentFrameText());
    }


}