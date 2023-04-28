package ie.plat.experiemental.filter.feeds.reapit.rules;

import ie.plat.experiemental.filter.Violation;
import ie.plat.experiemental.filter.feeds.reapit.ReapitFeedAd;
import java.util.Objects;
import java.util.Optional;

public class ReapitMissingFieldOneRule implements ReapitFilterRule {

  @Override
  public Optional<Violation> applyRule(ReapitFeedAd reapitFeedAd) {
    return Objects.nonNull(reapitFeedAd.getFieldOne()) ? Optional.empty()
        : Optional.of(Violation.REAPIT_FIELD_ONE_MISSING);
  }
}
