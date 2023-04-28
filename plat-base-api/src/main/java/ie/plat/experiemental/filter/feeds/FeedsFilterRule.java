package ie.plat.experiemental.filter.feeds;

import ie.plat.experiemental.filter.Violation;
import java.util.Optional;

public interface FeedsFilterRule<T> {

  Optional<Violation> applyRule(T abstractFeedAd);
}
