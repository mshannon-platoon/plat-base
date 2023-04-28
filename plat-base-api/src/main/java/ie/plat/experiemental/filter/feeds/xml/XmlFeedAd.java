package ie.plat.experiemental.filter.feeds.xml;

import ie.plat.experiemental.filter.model.AbstractFeedAd;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class XmlFeedAd extends AbstractFeedAd {

  private String fieldOne;
  private String fieldTwo;
  private String fieldThree;

}
