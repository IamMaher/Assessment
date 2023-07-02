package composite

import com.android.build.api.dsl.ApplicationExtension
import FeatureFlags
import Features
import org.gradle.api.Project


fun Project.configureVariants(android: ApplicationExtension) {

    android.apply {

        buildTypes {
            debug {
                isMinifyEnabled = false
                applicationIdSuffix = ".${BuildTypes.DEBUG}"
                isDebuggable = true
            }

            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }

            flavorDimensions(FlavorDimensions.DEFAULT)
            productFlavors {
                create(ProductFlavors.DEV) {
                    dimension = FlavorDimensions.DEFAULT
                    applicationIdSuffix = ".${ProductFlavors.DEV}"
                    versionNameSuffix = "-${ProductFlavors.DEV}"
                }
                create(ProductFlavors.INTERNAL) {
                    dimension = FlavorDimensions.DEFAULT
                    applicationIdSuffix = ".${ProductFlavors.INTERNAL}"
                    versionNameSuffix = "-${ProductFlavors.INTERNAL}"
                }
                create(ProductFlavors.PUBLIC) {
                    dimension = FlavorDimensions.DEFAULT
                }
            }

            /**
             * Process feature flags and if the feature is not included in a product flavor,
             * a default value of "false" or "deactivated" is used.
             *
             * @see FeatureFlags file definition.
             */
            productFlavors.map { flavor ->
                Features.values().forEach { feature ->
                    val activated = FeatureFlags.activated[flavor.name].orEmpty().contains(feature)
                    flavor.buildConfigField("Boolean", feature.name, activated.toString())
                }
            }
        }
    }
}

private object BuildTypes {
    const val DEBUG = "debug"
    const val RELEASE = "release"
}

object ProductFlavors {
    const val DEV = "dev"
    const val INTERNAL = "internal"
    const val PUBLIC = "public"
}

private object FlavorDimensions {
    const val DEFAULT = "default"
}

object Default {
    const val BUILD_TYPE = BuildTypes.DEBUG
    const val BUILD_FLAVOR = ProductFlavors.DEV

    val BUILD_VARIANT = "${BUILD_FLAVOR.capitalize()}${BUILD_TYPE.capitalize()}"
}