package org.clean.hexarch.adapter.profile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
class ProfileData {
  private String memberID;
  private String addressBookIndicator;
  private String primaryMemberIndicator;

  // TODO REmove -- Not used
  // private String transactionID;
}
