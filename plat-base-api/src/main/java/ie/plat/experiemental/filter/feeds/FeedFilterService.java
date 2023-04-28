package ie.plat.experiemental.filter.feeds;

import ie.plat.experiemental.filter.Violation;
import ie.plat.experiemental.filter.feeds.reapit.rules.ReapitMissingFieldOneRule;
import ie.plat.experiemental.filter.feeds.reapit.rules.ReapitMissingFieldThreeRule;
import ie.plat.experiemental.filter.feeds.xml.rules.XmlMissingFieldOneRule;
import ie.plat.experiemental.filter.feeds.xml.rules.XmlMissingFieldTwoRule;
import ie.plat.experiemental.filter.model.AbstractFeedAd;
import ie.plat.experiemental.filter.model.AdSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.util.CollectionUtils;

public class FeedFilterService {

  private final Map<AdSource, List<FeedsFilterRule>> filterRules = new HashMap<>();

  public FeedFilterService() {
    filterRules.put(AdSource.XML, List.of(new XmlMissingFieldOneRule(), new XmlMissingFieldTwoRule()));
    filterRules.put(AdSource.REAPIT, List.of(new ReapitMissingFieldOneRule(), new ReapitMissingFieldThreeRule()));
  }

  public Optional<AbstractFeedAd> filter(AbstractFeedAd abstractFeedAd) {
    return runValidations(abstractFeedAd, filterRules.get(abstractFeedAd.getAdSource()));
  }

  private Optional<AbstractFeedAd> runValidations(AbstractFeedAd abstractFeedAd, List<FeedsFilterRule> feedsFilterRules) {
    List<Violation> violationList = new ArrayList<>();
    feedsFilterRules.forEach(rule -> rule.applyRule(abstractFeedAd)
            .ifPresent(v -> violationList.add((Violation) v)));

    if (!CollectionUtils.isEmpty(violationList)){
      // Here is where we would persist the log of this object being pushed out of the import
      return Optional.empty();
    }

    return Optional.of(abstractFeedAd);
  }

}
