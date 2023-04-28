package ie.plat.experiemental.filter.feeds.xml.rules;

import ie.plat.experiemental.filter.Violation;
import ie.plat.experiemental.filter.feeds.xml.XmlFeedAd;
import java.util.Objects;
import java.util.Optional;

public class XmlMissingFieldTwoRule implements XmlFilterRule {

  @Override
  public Optional<Violation> applyRule(XmlFeedAd xmlFeedAd) {
    return Objects.nonNull(xmlFeedAd.getFieldTwo()) ? Optional.empty() : Optional.of(Violation.XML_FIELD_TWO_MISSING);
  }
}
