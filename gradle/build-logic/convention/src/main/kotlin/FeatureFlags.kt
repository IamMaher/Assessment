import composite.ProductFlavors

enum class Features {
    FEATURE_HELLO,
    FEATURE_BYE
}

/**
 * Defines a map for activated flags per product flavor.
 */
object FeatureFlags {
    val activated = mapOf(

        //Enabled Features for DEV Product Flavor
        ProductFlavors.DEV to setOf(
            Features.FEATURE_HELLO,
            Features.FEATURE_BYE
        ),

        //Enabled Features for INTERNAL Product Flavor
        ProductFlavors.INTERNAL to setOf(
            Features.FEATURE_BYE
        ),

        //Enabled Features for PUBLIC Product Flavor
        ProductFlavors.PUBLIC to setOf(
            Features.FEATURE_HELLO
        )
    )
}