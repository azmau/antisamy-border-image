# antisamy-border-image
Sample project for border-image bug in AntiSamy

The project contains a JUnit test case that fails but should not.
According to the policy file, the attribute `border-image` should only allow the value `none`. However, the test contains the value `border-image: url(border.png)` and the resulting `CleanResults` object contains no error messages.
