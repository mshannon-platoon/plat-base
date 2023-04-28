package ie.plat.experiemental.filter.feeds.reapit.rules;

import ie.plat.experiemental.filter.Violation;
import ie.plat.experiemental.filter.feeds.reapit.ReapitFeedAd;
import java.util.Objects;
import java.util.Optional;

public class ReapitMissingFieldThreeRule implements ReapitFilterRule {

  @Override
  public Optional<Violation> applyRule(ReapitFeedAd reapitFeedAd) {
    return Objects.nonNull(reapitFeedAd.getFieldThree()) ? Optional.empty()
        : Optional.of(Violation.REAPIT_FIELD_THREE_MISSING);
  }
}
