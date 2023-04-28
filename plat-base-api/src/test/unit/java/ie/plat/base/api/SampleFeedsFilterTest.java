package ie.plat.base.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ie.plat.experiemental.filter.feeds.FeedFilterService;
import ie.plat.experiemental.filter.feeds.xml.XmlFeedAd;
import ie.plat.experiemental.filter.model.AdSource;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class SampleFeedsFilterTest {

  @Test
  public void test() {
    XmlFeedAd xmlFeedAd = new XmlFeedAd();
    xmlFeedAd.setAdSource(AdSource.XML);
    FeedFilterService feedFilterService = new FeedFilterService();
    assertEquals(Optional.empty(), feedFilterService.filter(xmlFeedAd));
  }

}
